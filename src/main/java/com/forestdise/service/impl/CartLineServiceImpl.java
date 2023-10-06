package com.forestdise.service.impl;

import com.forestdise.converter.CartLineConverter;
import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.CartLine;
import com.forestdise.repository.CartLineRepository;
import com.forestdise.service.ICartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartLineServiceImpl implements ICartLineService {
    @Autowired
    private CartLineRepository cartLineRepository;

    @Autowired
    private CartLineConverter cartLineConverter;

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
    public void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception {
    }

    @Override
    public void removeCartLine(Long id) {
        cartLineRepository.deleteById(id);
    }
}
