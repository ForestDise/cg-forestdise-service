package com.forestdise.repository;
import com.forestdise.entity.Variant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VariantRepository  extends JpaRepository<Variant,Long > {
    List<Variant> findByProduct_Id(Long id);

    List<Variant> findVariantsByProductId(Long product_id);
    Variant findTopByProductIdOrderByPriceAsc(Long product_id);
    Page<Variant> findByNameContaining(String text, Pageable pageable);
    Page<Variant>findVariantsByNameContainingAndPriceBetween(String text,double minPrice, double maxPrice, Pageable pageable );
    @Query("SELECT AVG(r.variant.price) FROM Review r WHERE r.variant = :variant")
    Double findAverageStarByReview(@Param("variant") Variant variant);
}
