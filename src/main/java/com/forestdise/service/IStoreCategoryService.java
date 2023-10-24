package com.forestdise.service;

import com.forestdise.dto.StoreCategoryDTO;

import java.util.List;

public interface IStoreCategoryService {
    List<StoreCategoryDTO> createStoreCategorys(List<String> storeCateList, Long storeId);

    StoreCategoryDTO createStoreCategory(StoreCategoryDTO storeCategoryDTO, Long storeCategoryId);
}
