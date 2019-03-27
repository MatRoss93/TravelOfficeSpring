package com.travel.office.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private Address address;
    private Trip trip;

    public Customer(long id, String name, String surname, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
}
