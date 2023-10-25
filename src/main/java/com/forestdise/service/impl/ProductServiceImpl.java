package com.forestdise.service.impl;

import com.forestdise.converter.*;
import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductConverterImpl productConverterImpl;
    private final IVariantConverter variantConverter;
    private final IStoreConverter iStoreConverter;
    private final IOptionValueConverter iOptionValueConverter;
    private final IOptionTableConverter iOptionTableConverter;
    private final IBulletConverter iBulletConverter;
    private final ProductRepository productRepository;
    private final VariantRepository variantRepository;
    @Autowired
    public ProductServiceImpl(
            ProductConverterImpl productConverterImpl,
            IVariantConverter variantConverter,
            IStoreConverter iStoreConverter,
            IOptionValueConverter iOptionValueConverter,
            IOptionTableConverter iOptionTableConverter,
            IBulletConverter iBulletConverter,
            ProductRepository productRepository,
            VariantRepository variantRepository
    ) {
        this.productConverterImpl = productConverterImpl;
        this.variantConverter = variantConverter;
        this.iStoreConverter = iStoreConverter;
        this.iOptionValueConverter = iOptionValueConverter;
        this.iOptionTableConverter = iOptionTableConverter;
        this.iBulletConverter = iBulletConverter;
        this.productRepository = productRepository;
        this.variantRepository=variantRepository;
    }
    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product()) ;
        List<Bullet> bullets = product.getBulletList();
        List<BulletDto> bulletDtoList = iBulletConverter.entitiesToDTOs(bullets);
        ProductDto productDto = productConverterImpl.entityToDTO(product);
        productDto.setBulletDtoList(bulletDtoList);

        return productDto;
    }

    @Override
    public List<ProductDto> getAllProductDtos() {
        return productConverterImpl.entitiesToDTOs(productRepository.findAll());
    }

    @Override
    public List<VariantDto> getVariantsByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        List<Variant> variantList = product.getVariants();
        return variantConverter.entitiesToDTOs(variantList);
    }

    @Override
    public StoreDto getStoreByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        Store store = product.getStore();
        return iStoreConverter.entityToDTO(store);

    }

    @Override
    public List<OptionTableDto> getOptionsByProductId(Long productId) {
        List<OptionTableDto> optionTableDtoList = new ArrayList<>();
        Product product = productRepository.findById(productId).orElse(new Product());
        List<OptionTable> optionTableList = product.getOptionTables();
        for(OptionTable optionTable : optionTableList){
            List<OptionValue> optionValueList = optionTable.getOptionValues();
            List<OptionValueDto> optionValueDtoList = iOptionValueConverter.entitiesToDTOs(optionValueList);
            OptionTableDto optionTableDto = iOptionTableConverter.entityToDTO(optionTable);
            optionTableDto.setOptionValueDtoList(optionValueDtoList);
            optionTableDtoList.add(optionTableDto);
        }
        return optionTableDtoList;
    }

    @Override
    public Page<ProductDto> getProductsByContaining(String text, Pageable pageable) {

        Page<Product> products = productRepository.findByTitleContaining(text, pageable);
        return products.map(productConverterImpl::entityToDTO);
    }
    @Override
    public Page<ProductDto> getProductsByContainingAndSortByDecreasePricePriceVariant(String text, Pageable pageable) {
        Page<ProductDto> products= getProductsByContaining( text, pageable);
        products.forEach(productDto -> {
            Variant variant= variantRepository.findTopByProductIdOrderByPriceAsc(productDto.getId());
             if (variant != null) {
                productDto.setMinVariantPrice(variant.getPrice());
            }

        });
        List<ProductDto> sortedProductList = products.getContent()
                .stream()
                .sorted(Comparator.comparing(ProductDto::getMinVariantPrice, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());

        return new PageImpl<>(sortedProductList, pageable, products.getTotalElements());

    }
    @Override
    public Page<ProductDto> getProductsByContainingAndSortByIncreasePricePriceVariant(String text, Pageable pageable){
        Page<ProductDto> products = getProductsByContaining(text, pageable);
        products.forEach(productDto -> {
            Variant variant = variantRepository.findTopByProductIdOrderByPriceAsc(productDto.getId());
//            if (variant != null) {
                productDto.setMinVariantPrice(variant.getPrice());
//            } else {
//                productDto.setMinVariantPrice(0);
//            }
        });

        List<ProductDto> sortedProductList = products.getContent()
                .stream()
                .sorted(Comparator.comparing(ProductDto::getMinVariantPrice, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());

        return new PageImpl<>(sortedProductList, pageable, products.getTotalElements());
    }
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product= productConverterImpl.dtoToEntity(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDto productDto) {
        Product product = productConverterImpl.dtoToEntity(productDto);
        return productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
