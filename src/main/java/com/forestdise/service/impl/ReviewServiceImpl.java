package com.forestdise.service.impl;

import com.forestdise.converter.impl.OptionValueConverterImpl;
import com.forestdise.converter.impl.ReviewConverterImpl;
import com.forestdise.dto.*;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Review;
import com.forestdise.entity.Variant;
import com.forestdise.repository.ReviewRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements IReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewConverterImpl reviewConverter;
    private final VariantRepository variantRepository;
    private final OptionValueConverterImpl optionValueConverter;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             ReviewConverterImpl reviewConverter,
                             VariantRepository variantRepository,
                             OptionValueConverterImpl optionValueConverter
                             ) {
        this.reviewRepository = reviewRepository;
        this.reviewConverter = reviewConverter;
        this.variantRepository = variantRepository;
        this.optionValueConverter = optionValueConverter;
    }

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
        return reviewConverter.entitiesToDTOs(reviewList);
    }

    @Override
    public List<ReviewDto> getReviewsByProductId(Long productId){
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<Variant> variants = variantRepository.findVariantsByProductId(productId);
        for(Variant variant : variants){
            List<OptionValue> optionValues = variant.getOptionValues();
            List<Review> reviews = variant.getReviews();
            List<OptionValueDto> optionValueDtos = optionValueConverter.entitiesToDTOs(optionValues);
            List<ReviewDto> reviewDtos = reviewConverter.entitiesToDTOs(reviews);
            if(reviewDtos != null) {
                for (ReviewDto reviewDto : reviewDtos) {
                    reviewDto.setOptionValueDtoList(optionValueDtos);
                }
            }
            assert reviewDtos != null;
            reviewDtoList.addAll(reviewDtos);

        }

        return reviewDtoList;
    }

    @Override
    public SummaryDto getSummaryDtoByProductId(Long productId) {
        SummaryDto summaryDto = new SummaryDto();
        int total = getReviewsByProductId(productId).size();
        int count = 0;
        int countFiveStar = 0;
        int countFourStar = 0;
        int countThreeStar = 0;
        int countTwoStar = 0;
        int countOneStar = 0;
        List<Variant> variants = variantRepository.findVariantsByProductId(productId);
        for (Variant variant: variants) {
            List<Review> reviews = variant.getReviews();
            for (Review review: reviews) {
                if (review.getStar()==5) {
                    countFiveStar++;
                    count += 5;
                } else if (review.getStar()==4) {
                    countFourStar++;
                    count += 4;
                } else if (review.getStar()==3) {
                    countThreeStar++;
                    count += 3;
                } else if (review.getStar()==2) {
                    countTwoStar++;
                    count+=2;
                } else if (review.getStar()==1) {
                    countOneStar++;
                    count+=1;
                }
            }
        }

        RatingBreakdownDTO ratingBreakdownDTO = new RatingBreakdownDTO();
        ratingBreakdownDTO.setFiveStar(new RatingDTO(countFiveStar,  ((double)(countFiveStar/total)*100)));
        ratingBreakdownDTO.setFourStar(new RatingDTO(countFourStar, ( (double)countFourStar/total*100)));
        ratingBreakdownDTO.setThreeStar(new RatingDTO(countThreeStar,  ((double)countThreeStar/total*100)));
        ratingBreakdownDTO.setTwoStar(new RatingDTO(countTwoStar,  ((double)countTwoStar/total*100)));
        ratingBreakdownDTO.setOneStar(new RatingDTO(countOneStar,  ((double)countOneStar/total*100)));
        summaryDto.setRating((double) count /total);
        summaryDto.setReviewsTotal(total);
        summaryDto.setRatingBreakdown(ratingBreakdownDTO);

        return summaryDto;

    }

}
