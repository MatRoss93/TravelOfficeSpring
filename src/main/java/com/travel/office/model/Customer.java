package com.travel.office.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "trip_id", referencedColumnName = "id")
    private Trip trip;
    public Customer() {}
    public Customer(long id, String name, String surname, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
