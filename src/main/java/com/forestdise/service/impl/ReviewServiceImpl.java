package com.forestdise.service.impl;

import com.forestdise.converter.ReviewConverter;
import com.forestdise.dto.*;
import com.forestdise.entity.Review;
import com.forestdise.repository.ReviewRepository;
import com.forestdise.service.ProductService;
import com.forestdise.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewConverter reviewConverter;
    @Autowired
    private ProductService productService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewConverter reviewConverter, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
        this.productService = productService;
    }

    @Override
    public ReviewDTO getReviewById(Long id) {
        ReviewDTO reviewDto;
        Review review = reviewRepository.findById(id).orElse(new Review());
        reviewDto = reviewConverter.entityToDTO(review);
        return reviewDto;
    }

    @Override
    public List<ReviewDTO> getReviewsByVariantId(Long variantId) {
        List<Review> reviewList = reviewRepository.findByVariant_Id(variantId);
        List<ReviewDTO> reviewDTOList = reviewConverter.entitiesToDTOs(reviewList);
        return reviewDTOList;
    }

    @Override
    public List<ReviewDTO> getReviewsByProductId(Long productId){
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        List<VariantDTO> variantDTOList = productService.getVariantsByProductId(productId);
        for(VariantDTO variantDto : variantDTOList){
            List<OptionValueDTO> optionValueDTOList = variantDto.getOptionValueDTOList();
            reviewDTOList = variantDto.getReviewDTOList();
            if(reviewDTOList != null) {
                for (ReviewDTO reviewDto : reviewDTOList) {
                    reviewDto.setOptionValueDTOList(optionValueDTOList);
                }
            }
            reviewDTOList.addAll(getReviewsByVariantId(variantDto.getId()));
            //ddang sua
            //reviewDTOList null pointer exception
        }

        return reviewDTOList;
    }

    @Override
    public SummaryDTO getSummaryDtoByProductId(Long productId) {
        SummaryDTO summaryDto = new SummaryDTO();
        int total = 0;
        int count = 0;
        int countFiveStar = 0;
        int countFourStar = 0;
        int countThreeStar = 0;
        int countTwoStar = 0;
        int countOneStar = 0;
        List<VariantDTO> variantDTOList = productService.getVariantsByProductId(productId);
        for(VariantDTO variantDto : variantDTOList){
            List<ReviewDTO> reviewDTOList = variantDto.getReviewDTOList();
            total += reviewDTOList.size();
            for(ReviewDTO reviewDto : reviewDTOList){
                if(reviewDto.getStar() == 5){
                    countFiveStar++;
                    count += 5;
                } else if (reviewDto.getStar() == 4 ) {
                    countFourStar += 1;
                    count += 4;

                } else if (reviewDto.getStar() == 3) {
                    countThreeStar += 1;
                    count += 3;

                } else if (reviewDto.getStar() == 2) {
                    countTwoStar += 1;
                    count += 2;

                } else {
                    countOneStar += 1;
                    count += 1;

                }
            }
        }
        RatingBreakdownDTO ratingBreakdownDTO = new RatingBreakdownDTO();
        ratingBreakdownDTO.setFiveStar(new RatingDTO(countFiveStar,(countFiveStar/total*100)));
        ratingBreakdownDTO.setFourStar(new RatingDTO(countFourStar,(countFourStar/total*100)));
        ratingBreakdownDTO.setThreeStar(new RatingDTO(countThreeStar,(countThreeStar/total*100)));
        ratingBreakdownDTO.setTwoStar(new RatingDTO(countTwoStar,(countTwoStar/total*100)));
        ratingBreakdownDTO.setOneStar(new RatingDTO(countOneStar,(countOneStar/total*100)));
        summaryDto.setRating(count/total);
        summaryDto.setReviewsTotal(total);
        summaryDto.setRatingBreakdown(ratingBreakdownDTO);
        return summaryDto;
    }

}
