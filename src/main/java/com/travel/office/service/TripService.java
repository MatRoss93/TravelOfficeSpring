package com.travel.office.service;

import com.travel.office.model.Trip;
import com.travel.office.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

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
    public Trip findById(String id) {

        return tripRepository.findById(Long.valueOf(id)).orElseThrow(()-> new IllegalArgumentException("Invalid trip id:" + id));
    }

    public void save(Trip trip) {
        tripRepository.save(trip);

    }

    @Override
    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }

}
