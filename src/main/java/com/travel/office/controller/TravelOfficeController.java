package com.travel.office.controller;


import com.travel.office.model.Trip;
import com.travel.office.service.ICustomerService;
import com.travel.office.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TravelOfficeController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    ITripService tripService;

    @RequestMapping("/trips")
    public String availableTrips(Model model) {
        List<Trip> trips = tripService.findAll();
        return "trips";
    }

}
