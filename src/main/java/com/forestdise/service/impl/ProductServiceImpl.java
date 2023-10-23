package com.forestdise.service.impl;

import com.forestdise.converter.*;
import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    private final ProductConverterImpl productConverterImpl;
    private final IVariantConverter variantConverter;
    private final IStoreConverter iStoreConverter;
    private final IOptionValueConverter iOptionValueConverter;
    private final IOptionTableConverter iOptionTableConverter;
    private final IBulletConverter iBulletConverter;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(
            ProductConverterImpl productConverterImpl,
            IVariantConverter variantConverter,
            IStoreConverter iStoreConverter,
            IOptionValueConverter iOptionValueConverter,
            IOptionTableConverter iOptionTableConverter,
            IBulletConverter iBulletConverter,
            ProductRepository productRepository
    ) {
        this.productConverterImpl = productConverterImpl;
        this.variantConverter = variantConverter;
        this.iStoreConverter = iStoreConverter;
        this.iOptionValueConverter = iOptionValueConverter;
        this.iOptionTableConverter = iOptionTableConverter;
        this.iBulletConverter = iBulletConverter;
        this.productRepository = productRepository;
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
    public List<ProductDto> getProductsByContaining(String text) {
        List<Product> products = productRepository.findByTitleContaining(text);
        return productConverterImpl.entitiesToDTOs(products);

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
