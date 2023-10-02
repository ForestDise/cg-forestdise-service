package com.forestdise.converter;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.ProductAttribute;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductAttributeConverter {
    public List<ProductAttributeDto> entitiesToDTOs(List<ProductAttribute> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public ProductAttributeDto entityToDTO(ProductAttribute element) {
        ProductAttributeDto result = new ProductAttributeDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public ProductAttribute dtoToEntity(ProductAttributeDto element) {
        ProductAttribute result = new ProductAttribute();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
