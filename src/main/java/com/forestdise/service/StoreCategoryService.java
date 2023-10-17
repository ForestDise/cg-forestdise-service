package com.forestdise.service;

import com.forestdise.entity.StoreCategory;

import java.util.List;

public interface StoreCategoryService {
    List<StoreCategory> findAllSubCategoryByParentCategory(Long id);
    List<StoreCategory> findAllCategories(Long id);
}
