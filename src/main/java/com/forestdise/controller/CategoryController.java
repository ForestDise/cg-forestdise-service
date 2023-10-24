package com.forestdise.controller;

import com.forestdise.dto.CategoryDto;
import com.forestdise.dto.StoreDto;
import com.forestdise.payload.response.SearchCategoryResponse;
import com.forestdise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("/search")
    public ResponseEntity<SearchCategoryResponse> searchCategories(@RequestParam("query") String query){
        SearchCategoryResponse searchCategoryResponse = new SearchCategoryResponse();
        List<CategoryDto> categoryDtoList = iCategoryService.findByText(query);
        searchCategoryResponse.setCategoryDtoList(categoryDtoList);
        return ResponseEntity.ok(searchCategoryResponse);
    }
    @GetMapping("/{category_id}")
    public ResponseEntity<CategoryDto> getStore(@PathVariable("category_id") Long category_id) {
        CategoryDto CategoryDto = iCategoryService.findCategory(category_id);
        return new ResponseEntity<>(CategoryDto, HttpStatus.OK);
    }
}
