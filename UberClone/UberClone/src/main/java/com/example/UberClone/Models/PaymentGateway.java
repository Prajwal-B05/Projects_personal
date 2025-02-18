package com.example.UberClone.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "paymentGateway")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentGateway extends Auditable{

    private String name;

}
