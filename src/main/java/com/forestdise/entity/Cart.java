package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CART", uniqueConstraints = {@UniqueConstraint(name = "user_id_uk", columnNames = "user_id")})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartLine> cartLines;

    @OneToMany(mappedBy = "cart")
    private List<SaveForLater> saveForLaterList;
}
