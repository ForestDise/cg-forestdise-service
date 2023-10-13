package com.forestdise.repository;

import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;
import com.forestdise.entity.Variant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartLineRepository extends JpaRepository<CartLine, Long> {
    Page<CartLine> findAllBy(Pageable pageable);

    List<CartLine> findCartLineByCart(Cart cart);

    void deleteAllByCart(Cart cart);

    void deleteCartLineById(Long cartLineId);

    CartLine findCartLineByVariant (Variant variant);
}
