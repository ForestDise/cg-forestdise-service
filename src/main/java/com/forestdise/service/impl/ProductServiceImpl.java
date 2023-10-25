package com.forestdise.service.impl;

import com.forestdise.converter.*;
import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.CategoryRepository;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.StoreCategoryRepository;
import com.forestdise.repository.StoreRepository;
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
    private StoreConverter iStoreConverter;

    @Autowired
    private OptionValueConverter iOptionValueConverter;
    @Autowired
    private OptionTableConverter iOptionTableConverter;
    @Autowired
    private BulletConverter iBulletConverter;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StoreCategoryRepository storeCategoryRepository;
    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product()) ;
        List<Bullet> bullets = product.getBulletList();
        List<BulletDTO> bulletDtoList = iBulletConverter.entitiesToDTOs(bullets);
        ProductDTO productDto = productConverterImpl.entityToDTO(product);
        productDto.setBulletDtoList(bulletDtoList);

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
        StoreDTO storeDto = iStoreConverter.entityToDTO(store);
        return storeDto;
    }

    @Override
    public List<OptionTableDTO> getOptionsByProductId(Long productId) {
        List<OptionTableDTO> optionTableDtoList = new ArrayList<>();
        Product product = productRepository.findById(productId).orElse(new Product());
        List<OptionTable> optionTableList = product.getOptionTables();
        for(OptionTable optionTable : optionTableList){
            List<OptionValue> optionValueList = optionTable.getOptionValues();
            List<OptionValueDTO> optionValueDtoList = iOptionValueConverter.entitiesToDTOs(optionValueList);
            OptionTableDTO optionTableDto = iOptionTableConverter.entityToDTO(optionTable);
            optionTableDto.setOptionValueDtoList(optionValueDtoList);
            optionTableDtoList.add(optionTableDto);
        }
        return optionTableDtoList;
    }

    @Override
    public List<ProductDTO> getProductsByContaining(String text) {
        List<Product> products = productRepository.findByTitleContaining(text);
        return productConverterImpl.entitiesToDTOs(products);

    }
    @Override
    public Product createProduct(Long storeId,Long categoryId,Long storeCategoryId, ProductDTO productDto) {
        Store store = storeRepository.findById(storeId).orElse(new Store());
        Category category = categoryRepository.findById(categoryId).orElse(new Category());
        StoreCategory storeCategory = storeCategoryRepository.findById(storeCategoryId).orElse(new StoreCategory());
        Product product= productConverterImpl.dtoToEntity(productDto);
        product.setStore(store);
        product.setCategory(category);
        product.setStoreCategory(storeCategory);
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
