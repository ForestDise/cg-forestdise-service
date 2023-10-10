package com.forestdise.service.impl;

import com.forestdise.converter.CartLineConverter;
import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;
import com.forestdise.repository.CartLineRepository;
import com.forestdise.repository.CartRepository;
import com.forestdise.service.CartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartLineServiceImpl implements CartLineService {
    @Autowired
    private CartLineRepository cartLineRepository;

    @Autowired
    private CartLineConverter cartLineConverter;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Page<CartLine> findAll(Pageable pageable) {
        return cartLineRepository.findAll(pageable);
    }

    @Override
    public List<CartLineDto> findAll() {
        List<CartLine> cartLines = cartLineRepository.findAll();
        List<CartLineDto> cartLineDtos = cartLineConverter.convertEntitiesToDtos(cartLines);
        return cartLineDtos;
    }

    @Override
    public void saveCartLine(CartLineDto cartLineDto) {
        CartLine cartLine = cartLineConverter.convertDtoToEntity(cartLineDto);
        cartLineRepository.save(cartLine);
    }

    @Override
    public CartLine findCartLineById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception {
        CartLine cartLine = cartLineRepository.findById(id).orElse(null);
        cartLine.setQuantity(cartLineDto.getQuantity());
        cartLineRepository.save(cartLine);
    }

    @Override
    public void removeCartLine(Long id) {
        cartLineRepository.deleteById(id);
    }

    @Override
    public List<CartLineDto> findCartLinesByCartId(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        List<CartLine> cartLines = cartLineRepository.findCartLineByCart(cart);
        List<CartLineDto> cartLineDtos = cartLineConverter.convertEntitiesToDtos(cartLines);
        return cartLineDtos;
    }
}
