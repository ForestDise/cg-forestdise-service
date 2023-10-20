package com.forestdise.service.impl;

import com.forestdise.converter.SaveForLaterConverter;
import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.SaveForLater;
import com.forestdise.entity.Variant;
import com.forestdise.payload.request.SaveForLaterRequest;
import com.forestdise.repository.CartRepository;
import com.forestdise.repository.SaveForLaterRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.SaveForLaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveForLaterServiceImpl implements SaveForLaterService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private SaveForLaterRepository saveForLaterRepository;

    @Autowired
    private SaveForLaterConverter saveForLaterConverter;

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public List<SaveForLaterDto> findSaveForLaterByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        List<SaveForLater> saveForLaters = saveForLaterRepository.findSaveForLaterByCart(cart);
        List<SaveForLaterDto> saveForLaterDtos = saveForLaterConverter.convertEntitiesToDtos(saveForLaters);
        return saveForLaterDtos;
    }

    @Override
    public void removeSaveForLater(Long saveForLaterId) {
        saveForLaterRepository.deleteById(saveForLaterId);
    }

    @Override
    public SaveForLaterDto addSaveForLater(SaveForLaterRequest saveForLaterRequest) {
        SaveForLater saveForLater = new SaveForLater();
        Cart cart = cartRepository.findById(saveForLaterRequest.getCartId()).orElse(null);
        Variant variant = variantRepository.findById(saveForLaterRequest.getVariantId()).orElse(null);
        saveForLater.setCart(cart);
        saveForLater.setVariant(variant);
        saveForLater.setQuanity(saveForLaterRequest.getQuantity());
        saveForLaterRepository.save(saveForLater);
        SaveForLaterDto saveForLaterDto = saveForLaterConverter.convertEntityToDto(saveForLater);
        return saveForLaterDto;
    }
}
