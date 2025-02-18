package com.example.UberClone.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Driver")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver  extends Auditable{
    private Gender gender;
    private String name;

    @OneToOne
    private User user;

    @OneToOne (mappedBy = "driver")
    private Car car;

    private String licenseDetails;
    @Temporal(value = TemporalType.DATE)
    private Date dob;

    private DriverApprovalStatus driverApprovalStatus;

    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;
    private Boolean isAvailable;
    private String activeCity;

    @OneToOne
    private ExactLocation lastKnownLocation;
    @OneToOne
    private ExactLocation home;
    private String phoneNumber;

}
