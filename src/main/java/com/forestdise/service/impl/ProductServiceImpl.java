package com.forestdise.service.impl;

import com.forestdise.converter.*;
import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductConverterImpl productConverterImpl;
    @Autowired
    private VariantConverter variantConverter;

    @Autowired
    private StoreConverter storeConverter;

    @Autowired
    private OptionValueConverter optionValueConverter;
    @Autowired
    private OptionTableConverter optionTableConverter;
    @Autowired
    private BulletConverter bulletConverter;
    @Autowired
    private ProductRepository productRepository;
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
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = productConverterImpl.entitiesToDTOs(products);
        for(Product product: products){
            Store store = product.getStore();
            StoreDTO storeDto = storeConverter.entityToDTO(store);
            for(ProductDTO productDto: productDTOS){
                productDto.setStore(storeDto);
            }
        }
        return productDTOS;
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
        StoreDTO storeDto = storeConverter.entityToDTO(store);
        return storeDto;
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
    public List<ProductDTO> getProductsByContaining(String text) {
        List<Product> products = productRepository.findByTitleContaining(text);
        return productConverterImpl.entitiesToDTOs(products);

    }

    @Override
    public List<ProductDTO> getProductsOfStoreByContaining(Long id, String text) {
        List<Product> products = productRepository.findByTitleContaining(text);
        return productConverterImpl.entitiesToDTOs(products);
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
