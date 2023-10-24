package com.forestdise.converter;

import com.forestdise.dto.CategoryDto;
import com.forestdise.entity.Category;

import java.util.List;

public interface ICategoryConverter {
    List<CategoryDto> entitiesToDTOs(List<Category> element);
    CategoryDto entityToDTO(Category element);
    Category dtoToEntity(CategoryDto element);
}
