package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="STORE")

public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logo;
    private String homeImage;
    private String dealsImage;
    private String dealsSquareImage;
    private String interactiveImage;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonBackReference(value = "store_seller")
    private Seller seller;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference(value = "store_category")
    private List<StoreCategory> storeCategoryList;

    @OneToMany(mappedBy = "store")
    @JsonManagedReference(value = "store_product")
    private List<Product> productlist;

}
