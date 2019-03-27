package com.travel.office.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public abstract class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String destination;
    private LocalDate tripStartLocalDate;
    private LocalDate tripEndLocalDate;
    private double price;

    public Trip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price) {
        this.destination = destination;
        this.tripStartLocalDate = tripStartLocalDate;
        this.tripEndLocalDate = tripEndLocalDate;
        this.price = price;
    }
}
