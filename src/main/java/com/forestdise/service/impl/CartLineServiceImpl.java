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
        cartLineDtoList.add(new CartLineDto(1L,"Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops","Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",109.95,"men's clothing","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                10,"red"));
        cartLineDtoList.add(new CartLineDto(2L, "Mens Casual Premium Slim Fit T-Shirts", "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing. And Solid stitched shirts with round neck made for durability and a great fit for casual fashion wear and diehard baseball fans. The Henley style round neckline includes a three-button placket.", 22.3, "men's clothing", "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
                90,"blue"));
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
