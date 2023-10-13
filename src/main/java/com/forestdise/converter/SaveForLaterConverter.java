package com.forestdise.converter;

import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.entity.SaveForLater;

import java.util.List;

public interface SaveForLaterConverter {
    SaveForLater convertDtoToEntity(SaveForLaterDto saveForLaterDto);
    SaveForLaterDto convertEntityToDto(SaveForLater saveForLater);
    List<SaveForLaterDto> convertEntitiesToDtos(List<SaveForLater> saveForLaters);
    List<SaveForLater> convertDtoToEntities(List<SaveForLaterDto> cartLineDtos);
}
