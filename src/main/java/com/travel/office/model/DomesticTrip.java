package com.travel.office.model;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import java.time.LocalDate;

@Entity
@Data
@DiscriminatorValue("2")
public class DomesticTrip extends Trip {

    private Double ownArrivalDiscount;

    public DomesticTrip() {
        this.ownArrivalDiscount = 0.0;
    }

    public DomesticTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.ownArrivalDiscount = 0.0;
    }
}
