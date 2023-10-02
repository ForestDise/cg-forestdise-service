package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "optionvalue")
public class OptionValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "optionvalue_id")
    private OptionTable optionTable;
    @ManyToMany(mappedBy = "optionValues")
    private Set<Variant> variants;
}
