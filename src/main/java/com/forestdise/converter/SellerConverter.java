package com.forestdise.converter;

import com.forestdise.dto.SellerDTO;
import com.forestdise.dto.SellerLoginDTO;
import com.forestdise.entity.Seller;

import java.util.List;

public interface SellerConverter {
    SellerDTO convertEntityToDTO(Seller seller);
    List<SellerLoginDTO> convertEntitiesToDTOs(List<Seller> sellers);
}
