package com.forestdise.service;

import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.CartLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartLineService {
    Page<CartLine> findAll(Pageable pageable);

    List<CartLineDto> findAll();

    void saveCartLine(CartLineDto cartLineDto);

    CartLine findCartLineById(Long id);

    void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception;

    void removeCartLine(Long id);
}
