package com.travel.office.service;

import com.travel.office.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer findById(String id);
    void save(Customer customer);
    void delete (Customer customer);
}
