package com.forestdise.converter;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.SellerDto;
import com.forestdise.dto.UserDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.entity.Product;
import com.forestdise.entity.Seller;
import com.forestdise.entity.User;

import java.util.List;

public interface ISellerConverter {
    List<SellerDto> entitiesToDTOs(List<Seller> element);
    SellerDto entityToDTO(Seller element);
    Seller dtoToEntity(SellerDto element);
}
