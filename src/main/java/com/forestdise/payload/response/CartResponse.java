package com.forestdise.payload.response;

import com.forestdise.dto.CartLineDto;

import java.util.List;

public class CartResponse {
    private String message;
    private String statusCode;

    private List<CartLineDto> data;
}
