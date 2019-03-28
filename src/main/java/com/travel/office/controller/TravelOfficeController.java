package com.travel.office.controller;


import com.travel.office.model.AboardTrip;
import com.travel.office.model.Customer;
import com.travel.office.model.DomesticTrip;
import com.travel.office.model.Trip;
import com.travel.office.service.ICustomerService;
import com.travel.office.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TravelOfficeController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ITripService tripService;

    @RequestMapping("/trips")
    public List<Trip> availableTrips() {
        List<Trip> trips = tripService.findAll();
        if(trips.equals(null))
            System.out.println("Brak wycieczek w bazie");
        return trips;
    }

    @RequestMapping("/customers")
    public List<Customer> registeredCustomers() {
        List<Customer> customers = customerService.findAll();
        return customers;
    }

    @GetMapping("/trips/{id}")
    public Trip findTripById(@PathVariable("id") String id) {
        Trip trip = null;
        try {
            trip = tripService.findById(id);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getCause());
        }
        return trip;
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") String id) {
        Customer customer = null;
        try {
            customer = customerService.findById(id);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getCause());
        }
        return customer;
    }

    @GetMapping("/trips/addtrip")
    public String addTrip(@RequestParam String type, @RequestParam String dest, @RequestParam String start, @RequestParam String end, @RequestParam double price) {
        if(type.equals("2")) {
            Trip trip = new DomesticTrip(dest, LocalDate.parse(start), LocalDate.parse(end), price);
            tripService.save(trip);
            return trip.toString();
        }
        else if(type.equals("1")) {
            Trip trip = new AboardTrip(dest, LocalDate.parse(start), LocalDate.parse(end), price);
            tripService.save(trip);
            return trip.toString();
        } else
            return "Error";
    }

    @PostMapping("/customers/addcustomer")
    /*
    public String addCustomer(@RequestParam String name, @RequestParam String lName, @RequestParam String city,
                              @RequestParam String street, @RequestParam String zip) {
        ,


    }
    */
    public String addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return "";
    }
    @GetMapping("/trips/edit/{id}/{mod}")
    public String editTrip(@PathVariable("id") String id, @PathVariable("mod") Double mod) {
        Trip trip = null;
        if(tripService.findById(id) instanceof AboardTrip) {
            trip = (tripService.findById(id));
            ((AboardTrip) trip).setInsurance(mod);
            tripService.save(trip);
            return "";
        } else {
            trip = tripService.findById(id);
            ((DomesticTrip) trip).setOwnArrivalDiscount(mod);
            tripService.save(trip);
            return "";
        }

    }

    @GetMapping("/trips/delete/{id}")
    public String deleteTrip(@PathVariable("id") String id) {
        Trip trip = null;
        try {
            trip = tripService.findById(id);
            tripService.delete(trip);
            return "Trip deleted";
        } catch(IllegalArgumentException e) {
            return e.getCause().toString();
        }
    }



}
