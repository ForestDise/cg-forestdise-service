package com.forestdise.service;

import com.forestdise.dto.CartLineDto;
import com.forestdise.payload.request.CartLineRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartLineService {
    CartLineDto saveCartLine(CartLineRequest cartLineRequest);

    void updateCartLine(CartLineDto cartLineDto, Long id) throws Exception;

    void removeCartLine(Long id);

    List<CartLineDto> findCartLinesByCartId(Long cartId);

    void removeAllCartLines(Long cartId);
}
