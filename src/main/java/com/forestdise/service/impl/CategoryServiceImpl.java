package com.forestdise.service.impl;

import com.forestdise.converter.ICategoryConverter;
import com.forestdise.dto.CategoryDto;
import com.forestdise.entity.Category;
import com.forestdise.repository.CategoryRepository;
import com.forestdise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ICategoryConverter iCategoryConverter;
    @Override
    public List<CategoryDto> findByText(String text) {
        List<Category> categories = categoryRepository.findByAttributeContaining(text);
        List<CategoryDto> categoryDtoList = iCategoryConverter.entitiesToDTOs(categories);
        return categoryDtoList;
    }

    @Override
    public CategoryDto findCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("category not found"));
        CategoryDto categoryDto = iCategoryConverter.entityToDTO(category);
        return categoryDto;
    }
}
