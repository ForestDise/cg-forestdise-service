package com.forestdise.service;

import com.forestdise.dto.OptionTableDTO;
import com.forestdise.dto.ProductDTO;
import com.forestdise.dto.StoreDTO;
import com.forestdise.dto.VariantDTO;
import com.forestdise.entity.Product;

import java.util.List;

public interface ProductService {
    public ProductDTO getProductById(Long id);
    public List<ProductDTO> getAllProductDtos();
    public List<ProductDTO> getAllProductDtosByStore(Long id);
    List<ProductDTO> getAllProductDtosByStoreCategory(String categoryName);
    public List<VariantDTO> getVariantsByProductId(Long productId);
    public StoreDTO getStoreByProductId(Long productId);
    public List<OptionTableDTO> getOptionsByProductId(Long productId);
    public List<ProductDTO> getProductsByContaining(String text);

    List<ProductDTO> getProductsOfStoreByContaining(Long id, String text);
    public Product createProduct(ProductDTO productDto);
    public Product updateProduct(ProductDTO productDto);
    public void    deleteProduct(Long productId);

}
