package com.example.UberClone.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paymentRecipt")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReceipt extends Auditable{

    private Double amount;

    @ManyToOne
    private PaymentGateway paymentGateway;

    private String Details;
}
