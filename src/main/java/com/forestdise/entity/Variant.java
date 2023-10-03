package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "variant")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String skuCode;
    private int stockQuantity;
    private double weight;
    private double price;
    private String img;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    @OneToMany(mappedBy = "variant")
    private List<Image> images;
    @OneToMany(mappedBy = "variant")
    private List<Video> videos;
    @ManyToMany
    @JoinTable(name = "variant_option", joinColumns = @JoinColumn(name = "variant_id"),
                inverseJoinColumns = @JoinColumn(name = "optionvalue_id"))
    private Set<OptionValue>   optionValues;

    @OneToOne(mappedBy = "variant", cascade = CascadeType.PERSIST)
    private CartLine cartLine;
}
