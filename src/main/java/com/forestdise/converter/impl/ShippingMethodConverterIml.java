package com.forestdise.converter.impl;

import com.forestdise.converter.ShippingMethodConverter;
import com.forestdise.dto.ShippingMethodDto;
import com.forestdise.entity.ShippingMethod;
import com.forestdise.entity.ShopOrder;
import com.forestdise.service.ShopOrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ShippingMethodConverterIml implements ShippingMethodConverter {
    private ShopOrderService shopOrderService;

    @Override
    public ShippingMethod convertDtoToEntity(ShippingMethodDto shippingMethodDto) {
        ShippingMethod shippingMethod = new ShippingMethod();
        BeanUtils.copyProperties(shippingMethodDto,shippingMethod);
        ShopOrder shopOrder = shopOrderService.findById(shippingMethodDto.getId());
        shippingMethod.setShopOrders(shopOrder);
        return shippingMethod;
    }

    @Override
    public ShippingMethodDto convertEntityToDto(ShippingMethod shippingMethod) {
        return null;
    }

    @Override
    public List<ShippingMethodDto> convertEntitiesToDtos(List<ShippingMethod> shippingMethods) {
        return null;
    }

    @Override
    public List<ShippingMethod> convertDtoToEntities(List<ShippingMethodDto> shippingMethodDtos) {
        return null;
    }
}
