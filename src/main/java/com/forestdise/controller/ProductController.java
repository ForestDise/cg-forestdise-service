package com.forestdise.controller;

import com.forestdise.dto.ProductDto;
import com.forestdise.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @GetMapping
    public List<ProductDto> productDtoList(){
        return productServiceImpl.getAllProductDtos();
    }
}
