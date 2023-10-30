package com.forestdise.service;

<<<<<<< HEAD
import com.forestdise.entity.ShopOrder;

public interface ShopOrderService {
    ShopOrder findById(Long id);
=======
import com.forestdise.payload.request.ShopOrderRequest;
import com.forestdise.payload.response.ShopOrderResponse;

public interface ShopOrderService {
    ShopOrderResponse findShopOrder(Long userId);
    ShopOrderResponse createShopOrder(ShopOrderRequest shopOrderRequest);
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
}
