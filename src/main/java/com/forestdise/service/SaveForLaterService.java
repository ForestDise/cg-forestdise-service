package com.forestdise.service;

import com.forestdise.dto.SaveForLaterDTO;
import com.forestdise.payload.request.SaveForLaterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaveForLaterService {
    List<SaveForLaterDTO> findSaveForLaterByCartId (Long cartId);
    void removeSaveForLater(Long saveForLaterId);
    SaveForLaterDTO addSaveForLater(SaveForLaterRequest saveForLaterRequest);
}
