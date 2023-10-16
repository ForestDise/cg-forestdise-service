package com.forestdise.converter;

import com.forestdise.dto.ReviewDto;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Review;
import com.forestdise.entity.Store;

import java.util.List;

public interface IStoreConverter {
    List<StoreDto> entitiesToDTOs(List<Store> element);
    StoreDto entityToDTO(Store element);
    Store dtoToEntity(StoreDto element);
}
