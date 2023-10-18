package com.forestdise.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="review_id")
    @JsonBackReference(value = "comment_review")
    private Review review;

    @ManyToOne
    @JoinColumn(name="seller_id")
    @JsonBackReference(value = "comment_seller")
    private Seller seller;
}
