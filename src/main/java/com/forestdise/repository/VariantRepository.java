package com.forestdise.repository;
import com.forestdise.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface VariantRepository  extends JpaRepository<Variant,Long > {
    //    Optional<Variant> findById(Long id);
    List<Variant> findByProduct_Id(Long id);

    List<Variant> findVariantsByProductId(Long id);
    Variant findTopByProductIdOrderByPriceAsc(Long product_id);


}
