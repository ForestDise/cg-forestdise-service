package com.forestdise.service.impl;

import com.forestdise.converter.CartLineConverter;
import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;
import com.forestdise.entity.Variant;
import com.forestdise.payload.request.CartLineRequest;
import com.forestdise.repository.CartLineRepository;
import com.forestdise.repository.CartRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartLineServiceImpl implements CartLineService {
    @Autowired
    private CartLineRepository cartLineRepository;

    @Autowired
    private CartLineConverter cartLineConverter;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception {
        CartLine cartLine = cartLineRepository.findById(id).orElse(null);
        cartLine.setQuantity(cartLineDto.getQuantity());
        cartLineRepository.save(cartLine);
    }

    @Override
    public void removeCartLine(Long id) {
       CartLine cartLine = cartLineRepository.findById(id).orElse(null);
        cartLineRepository.deleteCartLineById(cartLine.getId());
    }

    @Override
    public List<CartLineDto> findCartLinesByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        List<CartLine> cartLines = cartLineRepository.findCartLineByCart(cart);
        List<CartLineDto> cartLineDtos = cartLineConverter.convertEntitiesToDtos(cartLines);
        return cartLineDtos;
    }

    @Override
    public void saveCartLine(CartLineRequest cartLineRequest) {
        Variant variant = variantRepository.findById(cartLineRequest.getVariantId()).orElse(null);
        Cart cart = cartRepository.findById(cartLineRequest.getCartId()).orElse(null);
        int quantity = cartLineRequest.getQuantity();
        CartLine cartLine = new CartLine();
        cartLine.setCart(cart);
        cartLine.setVariant(variant);
        cartLine.setQuantity(quantity);
        cartLineRepository.save(cartLine);
    }

    @Override
    public void removeAllCartLines(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        cartLineRepository.deleteAllByCart(cart);
    }
}
