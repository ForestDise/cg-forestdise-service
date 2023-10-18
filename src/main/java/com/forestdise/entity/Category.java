package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(name ="parent_Category_Id")
    private Category parentCategory;

    @JsonManagedReference(value = "product_category")
    @OneToMany ( mappedBy = "category")
    private List<Product> products;
}
