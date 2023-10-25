package com.forestdise.converter.impl;

import com.forestdise.converter.SellerConverter;
import com.forestdise.dto.SellerDTO;
import com.forestdise.dto.SellerLoginDTO;
import com.forestdise.entity.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellerConverterImpl implements SellerConverter {
    @Override
    public SellerDTO convertEntityToDTO(Seller seller) {
        SellerDTO result = new SellerDTO();
        BeanUtils.copyProperties(seller, result);
        return result;
    }

    @Override
    public List<SellerLoginDTO> convertEntitiesToDTOs(List<Seller> sellers) {
        return null;
    }
}
