package com.forestdise.service.impl;

import com.forestdise.converter.IReviewConverter;
import com.forestdise.converter.impl.ReviewConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.Review;
import com.forestdise.entity.Variant;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.ReviewRepository;
import com.forestdise.service.IProductService;
import com.forestdise.service.IReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements IReviewService {
    private ReviewRepository reviewRepository;
    private IReviewConverter reviewConverter;
    private ProductRepository productRepository;
    private IProductService productService;

    @Override
    public ReviewDto getReviewById(Long id) {
        ReviewDto reviewDto;
        Review review = reviewRepository.findById(id).orElse(new Review());
        reviewDto = reviewConverter.entityToDTO(review);
        return reviewDto;
    }

    @Override
    public List<ReviewDto> getReviewsByVariantId(Long variantId) {
        List<Review> reviewList = reviewRepository.findByVariant_Id(variantId);
        List<ReviewDto> reviewDtoList = reviewConverter.entitiesToDTOs(reviewList);
        return reviewDtoList;
    }

    @Override
    public List<ReviewDto> getReviewsByProductId(Long productId){
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<VariantDto> variantDtoList = productService.getVariantsByProductId(productId);
        for(VariantDto variantDto : variantDtoList){
            List<OptionValueDto> optionValueDtoList = variantDto.getOptionValueDtoList();
            reviewDtoList = variantDto.getReviewDtoList();
            for(ReviewDto reviewDto : reviewDtoList){
                reviewDto.setOptionValueDtoList(optionValueDtoList);
            }
            reviewDtoList.addAll(getReviewsByVariantId(variantDto.getId()));
            //ddang sua
        }

        return reviewDtoList;
    }

    @Override
    public SummaryDto getSummaryDtoByProductId(Long productId) {
        SummaryDto summaryDto = new SummaryDto();
        int total = 0;
        int count = 0;
        int countFiveStar = 0;
        int countFourStar = 0;
        int countThreeStar = 0;
        int countTwoStar = 0;
        int countOneStar = 0;
        List<VariantDto> variantDtoList = productService.getVariantsByProductId(productId);
        for(VariantDto variantDto : variantDtoList){
            List<ReviewDto> reviewDtoList = variantDto.getReviewDtoList();
            total += reviewDtoList.size();
            for(ReviewDto reviewDto : reviewDtoList){
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
