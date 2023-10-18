package com.forestdise.converter;

import com.forestdise.dto.ProductDto;
import com.forestdise.entity.Product;

import java.util.List;

public interface ProductConverter {
    List<ProductDto> entitiesToDTOs(List<Product> element);
    ProductDto entityToDTO(Product element);
    Product dtoToEntity(ProductDto element);
}
