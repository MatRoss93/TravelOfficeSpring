package com.travel.office.controller;


import com.travel.office.model.Customer;
import com.travel.office.model.DomesticTrip;
import com.travel.office.model.Trip;
import com.travel.office.service.ICustomerService;
import com.travel.office.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class TravelOfficeController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ITripService tripService;

    @RequestMapping("/trips")
    public List<Trip> availableTrips() {
        List<Trip> trips = tripService.findAll();
        return trips;
    }

    @RequestMapping("/customers")
    public List<Customer> registeredCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @RequestMapping("/trips/{id}")
    public Optional<Trip> findTripById(@RequestParam(name="id" , defaultValue = "0") long id) {
        Optional<Trip> trip = null;
        trip = tripService.findById(id);
        return trip;
    }

    @GetMapping("/addtrip")
    public void addTrip(@RequestParam String dest, @RequestParam String start, @RequestParam String end, @RequestParam double price) {
        Trip trip = new DomesticTrip(dest,LocalDate.parse(start),LocalDate.parse(end),price);
        tripService.save(trip);
    }

}
