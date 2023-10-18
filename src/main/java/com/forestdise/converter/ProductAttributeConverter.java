package com.forestdise.converter;

import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.ProductAttribute;

import java.util.List;

public interface ProductAttributeConverter {
    ProductAttribute dtoToEntity(ProductAttributeDto element);
    List<ProductAttributeDto> entitiesToDTOs(List<ProductAttribute> element);
    ProductAttributeDto entityToDTO(ProductAttribute element);
}
