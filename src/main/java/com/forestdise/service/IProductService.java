package com.forestdise.service;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.dto.ProductDto;
import com.forestdise.dto.StoreDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService {
    public ProductDto getProductById(Long id);
    public List<ProductDto> getAllProductDtos();
    public List<VariantDto> getVariantsByProductId(Long productId);
    public StoreDto getStoreByProductId(Long productId);
    public List<OptionTableDto> getOptionsByProductId(Long productId);
}
