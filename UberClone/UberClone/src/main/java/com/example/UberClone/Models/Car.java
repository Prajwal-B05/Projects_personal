package com.example.UberClone.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends Auditable {

    @ManyToOne
    private Color color;
    @OneToOne
    private Driver driver;

    private String plateNumber;
    private String model;
    private CarType carType;
}
