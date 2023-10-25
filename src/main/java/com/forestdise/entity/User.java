package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "address_user")
    private Set<Address> address;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToOne(mappedBy = "user")
    private ShopOrder shopOrder;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference(value = "user_review")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user_paymentMethod")
    private Set<PaymentMethod> paymentMethods;
}
