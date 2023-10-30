package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String district;

    private String ward;

    private String city;

    private String street;

<<<<<<< HEAD
    private boolean defaultAddress;

=======
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "address_user")
    private User user;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonBackReference(value = "address_seller")
    private Seller seller;

    @OneToMany(mappedBy = "address")
    @JsonManagedReference(value = "address_shopOrder")
    private Set<ShopOrder> shopOrders;
}
