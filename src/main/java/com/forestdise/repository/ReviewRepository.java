package com.forestdise.repository;

import com.forestdise.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findReviewsByVariantId(Long variantId);

    List<Review> findByVariant_Id(Long id);
}
