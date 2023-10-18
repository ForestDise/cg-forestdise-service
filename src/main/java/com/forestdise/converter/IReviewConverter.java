package com.forestdise.converter;

import com.forestdise.dto.ReviewDto;
import com.forestdise.entity.Review;

import java.util.List;

public interface IReviewConverter {
    List<ReviewDto> entitiesToDTOs(List<Review> element);
    ReviewDto entityToDTO(Review element);
    Review dtoToEntity(ReviewDto element);
}
