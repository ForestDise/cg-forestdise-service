package com.forestdise.repository;

import com.forestdise.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface VariantRepository  extends JpaRepository<Variant,Long > {
//    Optional<Variant> findById(Long id);
    List<Variant> findByProduct_Id(Long id);

    List<Variant> findVariantsByProductId(Long id);


}
