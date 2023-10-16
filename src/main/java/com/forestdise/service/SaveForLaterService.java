package com.forestdise.service;

import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.payload.request.SaveForLaterRequest;

import java.util.List;

public interface SaveForLaterService {
    List<SaveForLaterDto> findSaveForLaterByCartId (Long cartId);
    void removeSaveForLater(Long saveForLaterId);
    SaveForLaterDto addSaveForLater(SaveForLaterRequest saveForLaterRequest);
}
