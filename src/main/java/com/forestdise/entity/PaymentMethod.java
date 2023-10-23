package com.forestdise.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PAYMENT_METHOD")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
