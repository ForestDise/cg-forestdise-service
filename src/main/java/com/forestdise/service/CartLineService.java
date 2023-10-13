package com.forestdise.service;

import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.CartLine;
import com.forestdise.payload.request.CartLineRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CartLineService {
    CartLineDto saveCartLine(CartLineRequest cartLineRequest);

    void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception;

    void removeCartLine(Long id);

    List<CartLineDto> findCartLinesByCartId(Long cartId);

    void removeAllCartLines(Long cartId);
}
