package com.forestdise.converter.impl;

import com.forestdise.converter.IReviewConverter;
import com.forestdise.dto.ReviewDto;
import com.forestdise.entity.Review;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ReviewConverterImpl implements IReviewConverter {
    @Override
    public List<ReviewDto> entitiesToDTOs(List<Review> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto entityToDTO(Review element) {
        ReviewDto result = new ReviewDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Review dtoToEntity(ReviewDto element) {
        Review result = new Review();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}
