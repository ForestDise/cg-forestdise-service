package com.forestdise.service.impl;

import com.forestdise.converter.IStoreConverter;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Seller;
import com.forestdise.entity.Store;
import com.forestdise.repository.SellerRepository;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    IStoreConverter storeConverter;

    @Autowired
    SellerRepository sellerRepository;


    @Override
    public StoreDto findStore(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        return storeConverter.entityToDTO(store) ;
    }

    @Override
    public StoreDto createStore(Long sellerId, StoreDto storeDto) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(
                () -> new UsernameNotFoundException("seller not found"));
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setSeller(seller);
        storeRepository.save(store);
        StoreDto storeDto1 = storeConverter.entityToDTO(store);
        return storeDto1;
    }

}
