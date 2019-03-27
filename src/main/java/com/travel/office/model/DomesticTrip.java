package com.travel.office.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class DomesticTrip extends Trip {

    private double ownArrivalDiscount;

    public DomesticTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price, double ownArrivalDiscount) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.ownArrivalDiscount = ownArrivalDiscount;
    }
}
