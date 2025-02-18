package com.example.UberClone.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "namedLocation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NamedLocation extends Auditable {

    @OneToOne
    private ExactLocation exactLocation;

    private String name;
    private String pinCode;
    private String city;
    private String state;
    private String country;


}
