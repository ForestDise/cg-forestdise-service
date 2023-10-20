package com.forestdise.service;

import com.forestdise.dto.ReviewDto;
import com.forestdise.dto.SummaryDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IReviewService {
    public ReviewDto getReviewById(Long id);
    public List<ReviewDto> getReviewsByVariantId(Long variantId);
    public List<ReviewDto> getReviewsByProductId(Long productId);
    public SummaryDto getSummaryDtoByProductId(Long productId);
}
