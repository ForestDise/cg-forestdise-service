package com.forestdise.service;

import com.forestdise.dto.StoreCategoryDTO;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Store;

import java.util.List;

public interface StoreService {

    StoreDto findStore(Long id);
}
