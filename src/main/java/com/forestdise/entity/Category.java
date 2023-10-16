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
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attribute;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name ="parent_Category_Id")
    private Category parentCategory;

    @OneToMany ( mappedBy = "category")
    private List<Product> products;
}
