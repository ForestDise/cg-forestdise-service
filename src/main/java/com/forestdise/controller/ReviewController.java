package com.forestdise.controller;

import com.forestdise.payload.response.ReviewResponse;
<<<<<<< HEAD
import com.forestdise.service.IReviewService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
=======
import com.forestdise.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/reviews")
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
