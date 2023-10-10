package com.forestdise.converter;

import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;

import java.util.List;

public interface VariantConverter {
    List<VariantDto> entitiesToDTOs(List<Variant> element);
    VariantDto entityToDTO(Variant element);
    Variant dtoToEntity(VariantDto element);
}
