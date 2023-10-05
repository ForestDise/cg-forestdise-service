package com.forestdise.converter;

import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.ProductAttribute;

import java.util.List;

public interface IProductAttributeConverter {
    ProductAttribute dtoToEntity(ProductAttributeDto element);
    List<ProductAttributeDto> entitiesToDTOs(List<ProductAttribute> element);
    ProductAttributeDto entityToDTO(ProductAttribute element);
}
