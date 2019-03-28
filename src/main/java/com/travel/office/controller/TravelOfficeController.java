package com.travel.office.controller;


import com.travel.office.model.*;
import com.travel.office.service.ICustomerService;
import com.travel.office.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(trips.isEmpty())
            System.out.println("Empty trips database");
        return trips;
    }

    @RequestMapping("/customers")
    public List<Customer> registeredCustomers() {
        List<Customer> customers = customerService.findAll();
        if(customers.isEmpty())
            System.out.println("Empty client database");
        return customers;
    }

    @GetMapping("/trips/{id}")
    public Trip findTripById(@PathVariable("id") String id) {
        Trip trip = null;
        try {
            trip = tripService.findById(Long.valueOf(id));
        } catch(IllegalArgumentException e) {
            System.out.println(e.getCause());
        }
        return trip;
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") String id) {
        Customer customer = null;
        try {
            customer = customerService.findById(Long.valueOf(id));
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

    @GetMapping("/customers/addcustomer")
    public String addCustomer(@RequestParam String name, @RequestParam String lName, @RequestParam String city,
                              @RequestParam String street, @RequestParam String zip) {
        Address address = new Address(city,street,zip);
        Customer customer = new Customer(name, lName, address);
        customerService.save(customer);
        return "Customer added";
    }

    @GetMapping("/trips/edit/{id}/{mod}")
    public String editTrip(@PathVariable("id") String id, @PathVariable("mod") Double mod) {
        Trip trip = null;
        if(tripService.findById(Long.valueOf(id)) instanceof AboardTrip) {
            trip = (tripService.findById(Long.valueOf(id)));
            ((AboardTrip) trip).setInsurance(mod);
            tripService.save(trip);
            return "Insurance setted " + HttpStatus.OK;
        } else {
            trip = tripService.findById(Long.valueOf(id));
            ((DomesticTrip) trip).setOwnArrivalDiscount(mod);
            tripService.save(trip);
            return "Discount added" + HttpStatus.OK;
        }

    }

    @GetMapping("/customers/assign/{idC}/{idT}")
    public String editCustomer(@PathVariable("idC") String idC, @PathVariable("idT") String idT) {
        try {
            Customer customer = customerService.findById(Long.valueOf(idC));
            Trip trip = tripService.findById(Long.valueOf(idT));
            customer.setTrip(trip);
            customerService.save(customer);
            return "Trip assigned" + HttpStatus.OK;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }

    }
    @DeleteMapping("/trips/delete/{id}")
    public String deleteTrip(@PathVariable("id") String id) {
        Trip trip = null;
        try {
            trip = tripService.findById(Long.valueOf(id));
            tripService.delete(trip);
            return "Trip deleted" + HttpStatus.OK;
        } catch(IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") String id) {
        Customer customer = null;
        try {
            customer = customerService.findById(Long.valueOf(id));
            customerService.delete(customer);
            return "Customer deleted" + HttpStatus.OK.toString();
        } catch(IllegalArgumentException e) {
            return e.getMessage();
        }
    }

}
