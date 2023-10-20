package com.forestdise.controller;

import com.forestdise.payload.response.ReviewResponse;
import com.forestdise.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/reviews")
@AllArgsConstructor
public class ReviewController {
    @Autowired
    private ReviewService reviewService;


    @GetMapping("/{variant_id}")
    public ResponseEntity<ReviewResponse> getReviewsByVariantId(@PathVariable("variant_id") Long variantId){
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setReviewDTOList(reviewService.getReviewsByVariantId(variantId));
        return new ResponseEntity<>(reviewResponse, HttpStatus.OK);

    }
    @GetMapping("/product/{product_id}")
    public ResponseEntity<ReviewResponse> getReviewsByProductId(@PathVariable("product_id") Long productId){
        ReviewResponse reviewResponse = new ReviewResponse();
        reviewResponse.setReviewDTOList(reviewService.getReviewsByProductId(productId));
        reviewResponse.setSummaryDto(reviewService.getSummaryDtoByProductId(productId));
        return new ResponseEntity<>(reviewResponse, HttpStatus.OK);

    }


}
