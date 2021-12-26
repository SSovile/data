package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.company.dal.repository.CountryRepository;
import com.company.models.domain.address.Country;
import java.util.List;

import java.util.NoSuchElementException;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }

    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public void updateById(Customer customer, Integer id) {
        Customer updatedCustomer = customerRepository.findById(id).get();
        updatedCustomer.setFirstName(customer.getFirstName());
        updatedCustomer.setLastName(customer.getLastName());
        updatedCustomer.setEmail(customer.getEmail());
    }

    @Transactional
    public void deleteById(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        customerRepository.deleteById(id);
    }
}