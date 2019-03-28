package com.travel.office.service;

import com.travel.office.model.Trip;

import java.util.List;

public interface ITripService {

    List<Trip> findAll();
    Trip findById(Long id);
    void save(Trip trip);
    void delete (Trip trip);
}
