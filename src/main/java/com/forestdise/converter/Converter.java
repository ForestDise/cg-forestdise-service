package com.forestdise.converter;

public interface Converter <Q,E,P>{
    E convertFromRequestDtoToEntity(Q q);
    E convertFromResponseDtoToEntity(P p);
    Q convertFromEntityToRequestDto(E e);
    P convertFromEntityToResponseDto(E e);
}
