package com.forestdise.service.impl;

import com.forestdise.converter.SaveForLaterConverter;
import com.forestdise.dto.CartLineDto;
import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;
import com.forestdise.entity.SaveForLater;
import com.forestdise.repository.CartRepository;
import com.forestdise.repository.SaveForLaterRepository;
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

    @Override
    public List<SaveForLaterDto> findSaveForLaterByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        List<SaveForLater> saveForLaters = saveForLaterRepository.findSaveForLaterByCart(cart);
        List<SaveForLaterDto> saveForLaterDtos = saveForLaterConverter.convertEntitiesToDtos(saveForLaters);
        return saveForLaterDtos;
    }
}
