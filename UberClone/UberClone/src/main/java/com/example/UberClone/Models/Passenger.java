package com.example.UberClone.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Passsenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends Auditable {

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings = new ArrayList<>();

    @Temporal(value = TemporalType.DATE)
    private Date DOB;

    private String phoneNumber;

    @OneToOne
    private ExactLocation home;

    @OneToOne
    private ExactLocation work;

    @OneToOne
    private ExactLocation lastKnownLocation;




}
