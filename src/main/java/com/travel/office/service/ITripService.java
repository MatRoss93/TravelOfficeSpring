package com.travel.office.service;

import com.travel.office.model.Customer;
import com.travel.office.model.Trip;

import java.util.List;
import java.util.Optional;

public interface ITripService {

    List<Trip> findAll();
    Optional<Trip> findById(long id);
    void save(Trip trip);

}
