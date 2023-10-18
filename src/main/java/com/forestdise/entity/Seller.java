package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name ="SELLER")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seller_name")
    private String sellerName;
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference(value = "address_seller")
    private Set<Address> address;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference(value = "store_seller")
    private List<Store> storeList;

    @OneToMany(mappedBy = "seller")
    @JsonManagedReference(value = "comment_seller")
    private List<Comment> storeComments;
}
