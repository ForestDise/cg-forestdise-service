package com.forestdise.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.List;
import java.util.Set;
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "shipping_method")
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "shippingMethod")
<<<<<<< HEAD
    @JsonManagedReference(value = "shopOrder_shippingMethod")
    private ShopOrder shopOrders;
=======
    private ShopOrder shopOrder;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1

    private String name;

    private Double price;
}
