package com.travel.office.service;

import com.travel.office.model.Customer;
import com.travel.office.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        return customers;
    }

    public Customer findById(Long id) {
        return customerRepository.findById((id)).orElseThrow(()-> new IllegalArgumentException("Invalid customer id: " + id));
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

}
