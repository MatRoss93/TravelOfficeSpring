package com.travel.office.service;

import com.travel.office.model.Trip;
import com.travel.office.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService implements ITripService {

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        List<Trip> trips = (List<Trip>) tripRepository.findAll();
        return trips;
    }

    @Override
    public Optional<Trip> findById(long id) {
        return tripRepository.findById(id);
    }

    public void save(Trip trip) {
        tripRepository.save(trip);
    }
}
