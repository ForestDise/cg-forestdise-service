package com.forestdise.controller;

import com.forestdise.dto.ProductDto;
import com.forestdise.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/get-all-product")
    public List<ProductDto> productDtoList (){
        return productService.getAllProductDtos();
    }
}
