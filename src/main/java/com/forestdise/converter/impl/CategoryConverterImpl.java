package com.forestdise.converter.impl;

import com.forestdise.converter.ICategoryConverter;
import com.forestdise.dto.CategoryDto;
import com.forestdise.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class CategoryConverterImpl implements ICategoryConverter {
    @Override
    public List<CategoryDto> entitiesToDTOs(List<Category> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto entityToDTO(Category element) {
        CategoryDto result = new CategoryDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Category dtoToEntity(CategoryDto element) {
        Category result = new Category();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
