package com.forestdise.service;

import com.forestdise.dto.OptionTableDTO;
import com.forestdise.dto.ProductDTO;
import com.forestdise.dto.StoreDTO;
import com.forestdise.dto.VariantDTO;
import com.forestdise.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {
    public ProductDTO getProductById(Long id);
    public List<ProductDTO> getAllProductDtos();
     List<VariantDTO> getVariantsByProductId(Long productId);
     StoreDTO getStoreByProductId(Long productId);
     List<OptionTableDTO> getOptionsByProductId(Long productId);
     Page<ProductDTO> getProductsByContaining(String text, Pageable pageable);
     Product createProduct(ProductDTO productDto);
     Product updateProduct(ProductDTO productDto);
     void    deleteProduct(Long productId);
     Page<ProductDTO> getProductsByContainingAndSortByDecreasePricePriceVariant(String text, Pageable pageable);
     Page<ProductDTO> getProductsByContainingAndSortByIncreasePricePriceVariant(String text, Pageable pageable);
}
