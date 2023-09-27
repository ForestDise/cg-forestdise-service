package com.forestdise.service;

import com.forestdise.dto.cartline.CartLineRequestDto;
import com.forestdise.entity.CartLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartLineService {
    Page<CartLine> findAll(Pageable pageable);
    List<CartLine> findAll();
    void saveCartLine(CartLineRequestDto cartLineRequestDto);
    CartLine findCartLineById(Long id);
    void updateCartLine(CartLineRequestDto cartLineRequestDto, Long id) throws Exception;
    void removeCartLine(Long id);
}
