package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shop_order")
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    @JsonBackReference(value = "variant_shopOrder")
    private Variant variant;

    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference(value = "address_shopOrder")
    private Address address;

    @OneToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    private int quantity;

    private Double orderTotal;
}
