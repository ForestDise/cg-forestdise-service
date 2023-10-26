package com.forestdise.service.impl;

import com.forestdise.converter.ShopOrderConverter;
import com.forestdise.entity.Address;
import com.forestdise.entity.PaymentMethod;
import com.forestdise.entity.ShippingMethod;
import com.forestdise.entity.ShopOrder;
import com.forestdise.entity.User;
import com.forestdise.entity.Variant;
import com.forestdise.payload.request.ShopOrderRequest;
import com.forestdise.payload.response.PaymentMethodResponse;
import com.forestdise.payload.response.ShopOrderResponse;
import com.forestdise.repository.AddressRepository;
import com.forestdise.repository.PaymentMethodRepository;
import com.forestdise.repository.ShippingMethodRepository;
import com.forestdise.repository.ShopOrderRepository;
import com.forestdise.repository.UserRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements ShopOrderService {

    @Autowired
    private ShopOrderRepository shopOrderRepository;

    @Autowired
    private ShopOrderConverter shopOrderConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ShippingMethodRepository shippingMethodRepository;

    @Override
    public ShopOrderResponse findShopOrder(Long userId) {
        ShopOrder shopOrder = shopOrderRepository.findByUserId(userId);
        return shopOrderConverter.convertToDto(shopOrder);
    }

    @Override
    public ShopOrderResponse createShopOrder(ShopOrderRequest shopOrderRequest) {
        ShopOrder shopOrder = shopOrderConverter.convertToEntity(shopOrderRequest);
        User user = userRepository.findById(shopOrderRequest.getUserId()).get();
        Variant variant = variantRepository.findById(shopOrderRequest.getVariantId()).get();
        Address address = addressRepository.findById(shopOrderRequest.getAddressId()).get();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(shopOrderRequest.getPaymentMethodId()).get();
        ShippingMethod shippingMethod = shippingMethodRepository.findById(shopOrderRequest.getShippingMethodId()).get();
        shopOrder.setUser(user);
        shopOrder.setVariant(variant);
        shopOrder.setAddress(address);
        shopOrder.setPaymentMethod(paymentMethod);
        shopOrder.setShippingMethod(shippingMethod);
        ShopOrder shopOrderNew = shopOrderRepository.save(shopOrder);
        return shopOrderConverter.convertToDto(shopOrderNew);
    }
}
