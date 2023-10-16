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
    @Autowired
    private ProductConverterImpl productConverterImpl;
    @Autowired
    private IVariantConverter variantConverter;

    @Autowired
    private IStoreConverter iStoreConverter;

    @Autowired
    private IOptionValueConverter iOptionValueConverter;
    @Autowired
    private IOptionTableConverter iOptionTableConverter;
    @Autowired
    private IBulletConverter iBulletConverter;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(new Product()) ;
        List<Bullet> bullets = product.getBulletList();
        List<BulletDto> bulletDtoList = iBulletConverter.entitiesToDTOs(bullets);
        ProductDto productDto = productConverterImpl.entityToDTO(product);
        productDto.setBulletDtoList(bulletDtoList);
        // nullpointer exception

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
        StoreDto storeDto = iStoreConverter.entityToDTO(store);
        return storeDto;
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


}
