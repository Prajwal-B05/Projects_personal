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
@Table(name = "Booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends Auditable {

    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Driver driver;

    private BookingType bookingType;
    @OneToOne
    private Review reviewByUser ;
    @OneToOne
    private Review reviewByDriver ;
    @OneToOne
    private PaymentReceipt paymentReceipt;
    private BookingStatus bookingStatus;

    @OneToMany
    private List<ExactLocation> route = new ArrayList<>();
    @Temporal(value =TemporalType.TIMESTAMP)
    private Date startTime;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    @OneToOne
    private OTP riderStartOTP;
}
