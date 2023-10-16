package com.forestdise.repository;

import com.forestdise.entity.Product;
import com.forestdise.entity.Variant;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    List<Product> findAll();

//    List<Variant> findByProductId(Long productId);
}
