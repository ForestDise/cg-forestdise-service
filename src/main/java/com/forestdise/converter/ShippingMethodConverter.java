package com.forestdise.converter;

import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.dto.ShippingMethodDto;
import com.forestdise.entity.SaveForLater;
import com.forestdise.entity.ShippingMethod;

import java.util.List;

public interface ShippingMethodConverter {
    ShippingMethod convertDtoToEntity(ShippingMethodDto shippingMethodDto);
    ShippingMethodDto convertEntityToDto(ShippingMethod shippingMethod);
    List<ShippingMethodDto> convertEntitiesToDtos(List<ShippingMethod> shippingMethods);
    List<ShippingMethod> convertDtoToEntities(List<ShippingMethodDto> shippingMethodDtos);
}
