package com.forestdise.converter;

import com.forestdise.dto.ReviewDTO;
import com.forestdise.entity.Review;

import java.util.List;

public interface IReviewConverter {
    List<ReviewDTO> entitiesToDTOs(List<Review> element);
    ReviewDTO entityToDTO(Review element);
    Review dtoToEntity(ReviewDTO element);
}
