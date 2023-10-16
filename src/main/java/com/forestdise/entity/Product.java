package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String mainPicture;
    private String status;
    private Date createAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="store_category_id")
    private StoreCategory storeCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @OneToMany(mappedBy = "product")
    private List<OptionTable> optionTables;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
    private List<Variant> variants;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<ProductAttribute> productAttributes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<HashTag> hashTagList;

    @OneToMany(mappedBy = "product")
    private List<Bullet> bulletList;



}
