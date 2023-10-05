package com.forestdise.converter.impl;

import com.forestdise.converter.IProductConverter;
import com.forestdise.dto.ProductDto;
import com.forestdise.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductConverterImpl implements IProductConverter {
    @Override
    public List<ProductDto> entitiesToDTOs(List<Product> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto entityToDTO(Product element) {
        ProductDto result = new ProductDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Product dtoToEntity(ProductDto element) {
        Product result = new Product();
        BeanUtils.copyProperties(element, result);
        return result;
    }


}
