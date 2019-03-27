package com.travel.office.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class AboardTrip extends Trip{

    private double insurance;

    public AboardTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price, double insurance) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.insurance = insurance;
    }
}
