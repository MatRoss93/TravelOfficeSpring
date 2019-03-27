package com.travel.office.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@DiscriminatorValue("1")
public class AboardTrip extends Trip{

    private Double insurance;

    public  AboardTrip() {
        this.insurance = 0.0;
    }
    public AboardTrip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price) {
        super(destination, tripStartLocalDate, tripEndLocalDate, price);
        this.insurance = 0.0;
    }
}
