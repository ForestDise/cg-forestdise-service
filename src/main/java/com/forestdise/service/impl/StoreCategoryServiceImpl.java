package com.forestdise.service.impl;

import com.forestdise.entity.StoreCategory;
import com.forestdise.repository.StoreCategoryRepository;
import com.forestdise.service.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreCategoryServiceImpl implements StoreCategoryService {
    @Autowired
    StoreCategoryRepository storeCategoryRepository;

    @Override
    public List<StoreCategory> findAllSubCategoryByParentCategory(Long id) {
        StoreCategory parentCategory = storeCategoryRepository.findById(id).orElse(null);
        List<StoreCategory> subCategories = storeCategoryRepository.findAllByParentStoreCategory(parentCategory);
        return subCategories;
    }

    @Override
    public List<StoreCategory> findAllCategories(Long id) {
        return storeCategoryRepository.findAllById(id);
    }
}
