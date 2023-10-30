package com.forestdise.repository;

import com.forestdise.entity.ShippingMethod;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
=======
import com.forestdise.payload.response.ShippingMethodResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {
}
