package com.forestdise.repository;

import com.forestdise.entity.Product;

import com.forestdise.entity.Store;
import com.forestdise.entity.StoreCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);
    List<Product> findAll();
    List<Product> findByTitleContaining(String text);
<<<<<<< HEAD
    List<Product> findAllByStore(Store store);
    List<Product> findAllByStoreCategory(StoreCategory storeCategory);
}
=======

}
>>>>>>> 5b826ecbe86aa2ab3448ac690a61b616b22a4a0d
