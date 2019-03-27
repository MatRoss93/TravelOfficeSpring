package com.travel.office.service;



import com.travel.office.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    List<Customer> findAll();
    Optional<Customer> findById(long id);
}
