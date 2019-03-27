package com.travel.office.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.INTEGER,
        name="trip_type_id",
        columnDefinition = "TINYINT(1)")
public abstract class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String destination;
    private LocalDate tripStartLocalDate;
    private LocalDate tripEndLocalDate;
    private double price;

    public Trip() {}
    public Trip(String destination, LocalDate tripStartLocalDate, LocalDate tripEndLocalDate, double price) {
        this.destination = destination;
        this.tripStartLocalDate = tripStartLocalDate;
        this.tripEndLocalDate = tripEndLocalDate;
        this.price = price;
    }
}
