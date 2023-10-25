package com.forestdise.service.impl;

import com.forestdise.converter.StoreConverter;

import com.forestdise.converter.StoreCategoryConverter;
import com.forestdise.dto.StoreCategoryDTO;
import com.forestdise.dto.StoreDTO;
import com.forestdise.entity.Store;
import com.forestdise.entity.StoreCategory;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreConverter storeConverter;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, StoreConverter storeConverter) {
        this.storeRepository = storeRepository;
        this.storeConverter = storeConverter;
    }


    @Autowired
    StoreCategoryConverter storeCategoryConverter;
    @Override
    public StoreDTO findStore(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        List<StoreCategory> storeCategories = store.getStoreCategoryList();
        List<StoreCategoryDTO> storeCategoryDTOS = new ArrayList<>();
        List<StoreCategoryDTO> parentStoreCategoryDTOS = new ArrayList<>();
        for (StoreCategory storeCategory:
             storeCategories) {
           StoreCategoryDTO storeCategoryDTO = storeCategoryConverter.convertEntityToDTO(storeCategory);
           storeCategoryDTOS.add(storeCategoryDTO);
           StoreCategory parentStoreCategory = storeCategory.getParentStoreCategory();
           if(parentStoreCategory != null){
               StoreCategoryDTO parentStoreCategoryDTO = storeCategoryConverter.convertEntityToDTO(parentStoreCategory);
               parentStoreCategoryDTOS.add(parentStoreCategoryDTO);
           }
        }
        StoreDTO storeDto = storeConverter.entityToDTO(store);
        storeDto.setStoreCategoryList(storeCategoryDTOS);
        return storeDto;
    }
}
