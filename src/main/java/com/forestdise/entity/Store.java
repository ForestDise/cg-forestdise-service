package com.forestdise.entity;

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
    private String heroImage;
    private String interactiveImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="seller_id")
    private User seller;

    @OneToMany(mappedBy = "store")
    private List<StoreCategory> storeCategoryList;

    @OneToMany(mappedBy = "store")
    private List<Product> productlist;

}
