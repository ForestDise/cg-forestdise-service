package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "STORE_CATEGORY")
public class StoreCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parent_store_Category_Id")
    private StoreCategory parentStoreCategory;

    @OneToMany(mappedBy = "storeCategory")
    private List<Product> productList;


}
