package com.forestdise.entity;

<<<<<<< HEAD
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PAYMENT_METHOD")
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "payment_method")
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "nameOnCard")
    private String nameOnCard;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "default_payment")
    private boolean defaultPaynemt;

    @OneToOne(mappedBy = "paymentMethod")
    private ShopOrder shopOrder;
=======
    private String cartNumber;

    private String nameOnCard;

    private String expirationDate;

    private Boolean defaultPayment;

    @OneToOne(mappedBy = "paymentMethod")
    private ShopOrder shopOrder;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable=false)
    @JsonBackReference(value = "user_paymentMethod")
    private User user;
>>>>>>> d896aab58be7ada5f2da5a280775d98b27ad67e1
}
