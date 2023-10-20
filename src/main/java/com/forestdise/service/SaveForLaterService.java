package com.forestdise.service;

import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.payload.request.SaveForLaterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaveForLaterService {
    List<SaveForLaterDto> findSaveForLaterByCartId (Long cartId);
    void removeSaveForLater(Long saveForLaterId);
    SaveForLaterDto addSaveForLater(SaveForLaterRequest saveForLaterRequest);
}
