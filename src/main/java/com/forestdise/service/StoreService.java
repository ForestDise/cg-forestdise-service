package com.forestdise.service;

import com.forestdise.dto.StoreDto;
import com.forestdise.payload.request.AddStoreRequest;

public interface StoreService {

    StoreDto findStore(Long id);

    StoreDto createStore(Long sellerId, AddStoreRequest storeDto);
}
