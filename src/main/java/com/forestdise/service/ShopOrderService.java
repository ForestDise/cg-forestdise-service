package com.forestdise.service;

import com.forestdise.payload.request.ShopOrderRequest;
import com.forestdise.payload.response.ShopOrderResponse;

public interface ShopOrderService {
    ShopOrderResponse findShopOrder(Long userId);
    ShopOrderResponse createShopOrder(ShopOrderRequest shopOrderRequest);
}
