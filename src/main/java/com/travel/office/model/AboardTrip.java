package com.travel.office.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class AboardTrip extends Trip{

    private long id;
    private double insurance;

    public AboardTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price, double insurance) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.insurance = insurance;
    }
}
