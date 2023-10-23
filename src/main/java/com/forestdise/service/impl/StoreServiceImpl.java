package com.forestdise.service.impl;

import com.forestdise.converter.IStoreConverter;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Store;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final IStoreConverter storeConverter;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository, IStoreConverter storeConverter) {
        this.storeRepository = storeRepository;
        this.storeConverter = storeConverter;
    }

    @Override
    public StoreDto findStore(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        return storeConverter.entityToDTO(store) ;
    }
}
