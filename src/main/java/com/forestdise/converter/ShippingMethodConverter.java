package com.forestdise.converter;

<<<<<<< HEAD
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
=======
import com.forestdise.entity.ShippingMethod;
import com.forestdise.payload.response.ShippingMethodResponse;

public interface ShippingMethodConverter {
    ShippingMethodResponse convertToDto(ShippingMethod shippingMethod);
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
}
