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

<<<<<<< HEAD
    @OneToMany(mappedBy = "shopOrder")
    private List<Variant> variantList;
=======
    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    @JsonBackReference(value = "variant_shopOrder")
    private Variant variant;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1

    private String orderDate;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonBackReference(value = "address_shopOrder")
    private Address address;

    @OneToOne
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
<<<<<<< HEAD
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    @OneToOne
=======
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;

    private int quantity;

<<<<<<< HEAD
    private double orderTotal;
=======
    private Double orderTotal;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
}
