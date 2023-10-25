package com.forestdise.service.impl;

import com.forestdise.converter.*;
import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    private final ProductConverterImpl productConverterImpl;
    private final VariantConverter variantConverter;
    private final StoreConverter storeConverter;
    private final OptionValueConverter optionValueConverter;
    private final OptionTableConverter optionTableConverter;
    private final BulletConverter bulletConverter;
    private final ProductRepository productRepository;
    private final VariantRepository variantRepository;
    @Autowired
    public ProductServiceImpl(
            ProductConverterImpl productConverterImpl,
            VariantConverter variantConverter,
            StoreConverter storeConverter,
            OptionValueConverter optionValueConverter,
            OptionTableConverter optionTableConverter,
            BulletConverter bulletConverter,
            ProductRepository productRepository,
            VariantRepository variantRepository
    ) {
        this.productConverterImpl = productConverterImpl;
        this.variantConverter = variantConverter;
        this.storeConverter = storeConverter;
        this.optionValueConverter = optionValueConverter;
        this.optionTableConverter = optionTableConverter;
        this.bulletConverter = bulletConverter;
        this.productRepository = productRepository;
        this.variantRepository=variantRepository;
    }
    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product()) ;
        List<Bullet> bullets = product.getBulletList();
        List<BulletDTO> bulletDTOList = bulletConverter.entitiesToDTOs(bullets);
        ProductDTO productDto = productConverterImpl.entityToDTO(product);
        productDto.setBulletDTOList(bulletDTOList);

        return productDto;
    }

    @Override
    public List<ProductDTO> getAllProductDtos() {
        return productConverterImpl.entitiesToDTOs(productRepository.findAll());
    }

    @Override
    public List<VariantDTO> getVariantsByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        List<Variant> variantList = product.getVariants();
        return variantConverter.entitiesToDTOs(variantList);
    }

    @Override
    public StoreDTO getStoreByProductId(Long productId) {
        Product product = productRepository.findById(productId).orElse(new Product());
        Store store = product.getStore();
        return storeConverter.entityToDTO(store);

    }

    @Override
    public List<OptionTableDTO> getOptionsByProductId(Long productId) {
        List<OptionTableDTO> optionTableDTOList = new ArrayList<>();
        Product product = productRepository.findById(productId).orElse(new Product());
        List<OptionTable> optionTableList = product.getOptionTables();
        for(OptionTable optionTable : optionTableList){
            List<OptionValue> optionValueList = optionTable.getOptionValues();
            List<OptionValueDTO> optionValueDTOList = optionValueConverter.entitiesToDTOs(optionValueList);
            OptionTableDTO optionTableDto = optionTableConverter.entityToDTO(optionTable);
            optionTableDto.setOptionValueDTOList(optionValueDTOList);
            optionTableDTOList.add(optionTableDto);
        }
        return optionTableDTOList;
    }

    @Override
    public Page<ProductDTO> getProductsByContaining(String text, Pageable pageable) {

        Page<Product> products = productRepository.findByTitleContaining(text, pageable);
        return products.map(productConverterImpl::entityToDTO);
    }
    @Override
    public Page<ProductDTO> getProductsByContainingAndSortByDecreasePricePriceVariant(String text, Pageable pageable) {
        Page<ProductDTO> products= getProductsByContaining( text, pageable);
        products.forEach(productDto -> {
            Variant variant= variantRepository.findTopByProductIdOrderByPriceAsc(productDto.getId());
             if (variant != null) {
                productDto.setMinVariantPrice(variant.getPrice());
            }

        });
        List<ProductDTO> sortedProductList = products.getContent()
                .stream()
                .sorted(Comparator.comparing(ProductDTO::getMinVariantPrice, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());

        return new PageImpl<>(sortedProductList, pageable, products.getTotalElements());

    }
    @Override
    public Page<ProductDTO> getProductsByContainingAndSortByIncreasePricePriceVariant(String text, Pageable pageable){
        Page<ProductDTO> products = getProductsByContaining(text, pageable);
        products.forEach(productDto -> {
            Variant variant = variantRepository.findTopByProductIdOrderByPriceAsc(productDto.getId());
//            if (variant != null) {
                productDto.setMinVariantPrice(variant.getPrice());
//            } else {
//                productDto.setMinVariantPrice(0);
//            }
        });

        List<ProductDTO> sortedProductList = products.getContent()
                .stream()
                .sorted(Comparator.comparing(ProductDTO::getMinVariantPrice, Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());

        return new PageImpl<>(sortedProductList, pageable, products.getTotalElements());
    }
    @Override
    public Product createProduct(ProductDTO productDto) {
        Product product= productConverterImpl.dtoToEntity(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(ProductDTO productDto) {
        Product product = productConverterImpl.dtoToEntity(productDto);
        return productRepository.save(product);

    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

}
