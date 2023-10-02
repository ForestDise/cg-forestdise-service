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
@Table(name = "product")
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
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<Variant> variants;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "product")
    private List<ProductAttribute> productAttributes;

}
