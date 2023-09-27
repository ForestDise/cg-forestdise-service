package com.forestdise.service.impl;

import com.forestdise.dto.cartline.CartLineRequestDto;
import com.forestdise.entity.CartLine;
import com.forestdise.repository.CartLineRepository;
import com.forestdise.service.ICartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartLineServiceImpl implements ICartLineService {
    @Autowired
    private CartLineRepository cartLineRepository;
    @Override
    public Page<CartLine> findAll(Pageable pageable) {
        return cartLineRepository.findAll(pageable);
    }

    @Override
    public List<CartLine> findAll() {
        return cartLineRepository.findAll();
    }

    @Override
    public void saveCartLine(CartLineRequestDto cartLineRequestDto) {
    }

    @Override
    public CartLine findCartLineById(Long id) {
        return null;
    }

    @Override
    public void updateCartLine(CartLineRequestDto cartLineRequestDto, Long id) throws Exception {
    }

    @Override
    public void removeCartLine(Long id) {
        cartLineRepository.deleteById(id);
    }
}
