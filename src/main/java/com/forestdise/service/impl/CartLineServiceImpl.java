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
    private final CartLineRepository cartLineRepository;
    private final CartLineConverter cartLineConverter;
    private final CartRepository cartRepository;
    private final VariantRepository variantRepository;

    @Autowired
    public CartLineServiceImpl(CartLineRepository cartLineRepository, CartLineConverter cartLineConverter, CartRepository cartRepository, VariantRepository variantRepository) {
        this.cartLineRepository = cartLineRepository;
        this.cartLineConverter = cartLineConverter;
        this.cartRepository = cartRepository;
        this.variantRepository = variantRepository;
    }

    @Override
    public void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception {
        CartLine cartLine = cartLineRepository.findById(id).orElse(null);
        cartLine.setQuantity(cartLineDto.getQuantity());
        cartLineRepository.save(cartLine);
    }

    @Override
    public void removeCartLine(Long id) {
       CartLine cartLine = cartLineRepository.findById(id).orElse(null);
        assert cartLine != null;
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
    public CartLineDto saveCartLine(CartLineRequest cartLineRequest) {
        Variant variant = variantRepository.findById(cartLineRequest.getVariantId()).orElse(null);
        Cart cart = cartRepository.findById(cartLineRequest.getCartId()).orElse(null);
        CartLine cartLine = cartLineRepository.findCartLineByVariant(variant);
        if (cartLine != null) {
            int newQuantity = cartLine.getQuantity() + 1;
            cartLine.setQuantity(newQuantity);
            cartLineRepository.save(cartLine);
            return cartLineConverter.convertEntityToDto(cartLine);

        }
        int quantity = cartLineRequest.getQuantity();
        CartLine newCartLine = new CartLine();
        newCartLine.setCart(cart);
        newCartLine.setVariant(variant);
        newCartLine.setQuantity(quantity);
        cartLineRepository.save(newCartLine);
        return   cartLineConverter.convertEntityToDto(newCartLine);
    }

    @Override
    public void removeAllCartLines(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        cartLineRepository.deleteAllByCart(cart);
    }
}
