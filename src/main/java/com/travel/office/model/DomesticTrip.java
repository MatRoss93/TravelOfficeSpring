package com.travel.office.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class DomesticTrip extends Trip {

    private double ownArrivalDiscount;

    public DomesticTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price, double ownArrivalDiscount) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}
