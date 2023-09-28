package com.forestdise.service.impl;

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
    private static List<CartLineDto>  cartLineDtoList = new ArrayList<>();
    static {
        cartLineDtoList.add(new CartLineDto(1L,"codegym","abc",50.99,"men's clothing","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                10,"red"));
    }

    @Override
    public Page<CartLine> findAll(Pageable pageable) {
        return cartLineRepository.findAll(pageable);
    }

    @Override
    public List<CartLineDto> findAll() {
        return cartLineDtoList;
    }

    @Override
    public void saveCartLine(CartLineDto cartLineDto) {
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
