package com.forestdise.service;

import com.forestdise.dto.CategoryDto;
import com.forestdise.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> findByText(String text);

    CategoryDto findCategory(Long categoryId);
}
