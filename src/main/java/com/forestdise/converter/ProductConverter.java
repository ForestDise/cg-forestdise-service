package com.forestdise.converter;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Product;
import com.forestdise.entity.Variant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductConverter {
    @Autowired
    private VariantConverter variantConverter;
    public List<ProductDto> entitiesToDTOs(List<Product> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public ProductDto entityToDTO(Product element) {
        ProductDto result = new ProductDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public Product dtoToEntity(ProductDto element) {
        Product result = new Product();
        BeanUtils.copyProperties(element, result);
        return result;
    }
//    public List<VariantDto> variantDtos (Product product){
//        List<Variant> variants = product.getVariants();
//        List<VariantDto> variantDTOs = new ArrayList<>();
//        for (Variant variant : variants) {
//            VariantDto variantDTO = new VariantDto();
//            BeanUtils.copyProperties(variant, variantDTO);
//            variantDTOs.add(variantDTO);
//        }
//        return variantDTOs;
//    }
//    public List<VariantDto> variantDtos (Product product) {
//        List<Variant> variants = product.getVariants();
//        List<VariantDto> variantDTOs = new ArrayList<>();
//        for (Variant variant : variants) {
//            VariantDto variantDTO = new VariantDto();
//            BeanUtils.copyProperties(variant, variantDTO);
//            variantDTOs.add(variantDTO);
//        }
//        return variantDTOs;
//    }


}
