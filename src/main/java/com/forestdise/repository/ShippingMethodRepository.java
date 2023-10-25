package com.forestdise.repository;

import com.forestdise.entity.ShippingMethod;
import com.forestdise.payload.response.ShippingMethodResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShippingMethodRepository extends JpaRepository<ShippingMethod, Long> {
}
