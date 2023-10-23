package com.forestdise.service.impl;

import com.forestdise.entity.ShopOrder;
import com.forestdise.repository.ShopOderRepository;
import com.forestdise.service.ShopOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShopOrderServiceImpl implements ShopOrderService {
    private ShopOderRepository shopOderRepository;
    @Override
    public ShopOrder findById(Long id) {
        ShopOrder shopOrder = shopOderRepository.findById(id).orElse(null);
        return shopOrder;
    }
}
