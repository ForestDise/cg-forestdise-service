package com.forestdise.repository;

import com.forestdise.entity.CartLine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {
    Page<CartLine> findAllBy(Pageable pageable);

    CartLine findCartLineById(Long id);
}
