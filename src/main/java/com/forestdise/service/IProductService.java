package com.forestdise.service;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.dto.ProductDto;
import com.forestdise.dto.StoreDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
    public ProductDto getProductById(Long id);
    public List<ProductDto> getAllProductDtos();
     List<VariantDto> getVariantsByProductId(Long productId);
     StoreDto getStoreByProductId(Long productId);
     List<OptionTableDto> getOptionsByProductId(Long productId);
     Page<ProductDto> getProductsByContaining(String text, Pageable pageable);
     Product createProduct(ProductDto productDto);
     Product updateProduct(ProductDto productDto);
     void    deleteProduct(Long productId);
     Page<ProductDto> getProductsByContainingAndSortByDecreasePricePriceVariant(String text, Pageable pageable);
     Page<ProductDto> getProductsByContainingAndSortByIncreasePricePriceVariant(String text, Pageable pageable);
}
