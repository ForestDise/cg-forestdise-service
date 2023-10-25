package com.forestdise.service.impl;

import com.forestdise.converter.StoreConverter;
import com.forestdise.dto.StoreDTO;
import com.forestdise.entity.Seller;
import com.forestdise.entity.Store;
import com.forestdise.payload.request.AddStoreRequest;
import com.forestdise.repository.SellerRepository;
import com.forestdise.converter.StoreCategoryConverter;
import com.forestdise.dto.StoreCategoryDTO;
import com.forestdise.entity.StoreCategory;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreConverter storeConverter;

    @Autowired
    SellerRepository sellerRepository;

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

    @Override
    public StoreDTO createStore(Long sellerId, AddStoreRequest storeDto) {
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(
                () -> new UsernameNotFoundException("seller not found"));
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setDealsImage("https://m.media-amazon.com/images/S/stores-image-uploads-na-prod/0/AmazonStores/ATVPDKIKX0DER/d890cc345132240fe640b84cb42529d4.w3000.h600._CR0%2C0%2C3000%2C600_SX1500_.jpg");
        store.setHomeImage("https://m.media-amazon.com/images/S/aplus-media-library-service-media/f5070351-bae5-4422-9370-15981da15997.__CR0,0,1464,600_PT0_SX1464_V1___.jpg");
        store.setDealsSquareImage("https://m.media-amazon.com/images/S/aplus-media-library-service-media/f5070351-bae5-4422-9370-15981da15997.__CR0,0,1464,600_PT0_SX1464_V1___.jpg");
        store.setInteractiveImage("https://m.media-amazon.com/images/S/aplus-media-library-service-media/43c6800b-a62d-4e88-b881-70fa9f5c91ee.__CR0,0,1464,600_PT0_SX1464_V1___.jpg");
        store.setLogo("https://m.media-amazon.com/images/S/abs-image-upload-na/0/AmazonStores/ATVPDKIKX0DER/405ed15fea3c3d0a0f0e6d0dbd5baca8.w1676.h1677._CR0%2C0%2C1676%2C1677_SX200_.jpg");
        store.setSeller(seller);
        storeRepository.save(store);
        StoreDTO storeDto1 = storeConverter.entityToDTO(store);
        return storeDto1;
    }

}
