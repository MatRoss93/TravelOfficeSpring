package com.travel.office.controller;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import com.travel.office.model.Address;
import com.travel.office.model.Customer;
import com.travel.office.model.DomesticTrip;
import com.travel.office.model.Trip;
import com.travel.office.service.CustomerService;
import com.travel.office.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TravelOfficeController.class)
public class TravelOfficeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TripService tripService;

    @MockBean
    private CustomerService customerService;

    @Test
    public void availableTrips() throws Exception{
        Trip trip = new DomesticTrip("wioska", LocalDate.parse("2000-10-10"), LocalDate.parse("2000-10-10"), 10000);
        List<Trip> allTrips = Arrays.asList(trip);

        given(tripService.findAll()).willReturn(allTrips);
        mvc.perform(get("/trips").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void registeredCustomers() throws Exception{
        Customer tim = new Customer("tim","doe",new Address("a","b","c"));
        List<Customer> allCustomers = new ArrayList<>();
        allCustomers.add(tim);
        allCustomers.add(new Customer("jim","doe",new Address("a","b","c")));

        given(customerService.findAll()).willReturn(allCustomers);

        mvc.perform(get("/customers").contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void findTripById() throws Exception {

    }

    @Test
    public void findCustomerById() {
    }

    @Test
    public void addTrip() {
    }

    @Test
    public void addCustomer() {
    }

    @Test
    public void editTrip() {
    }

    @Test
    public void editCustomer() {
    }

    @Test
    public void deleteTrip() {
    }

    @Test
    public void deleteCustomer() {
    }
}