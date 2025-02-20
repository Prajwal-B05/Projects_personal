package com.example.UberClone.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exactlocation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExactLocation extends Auditable{
    private String latitude;
    private String longitude;
}
