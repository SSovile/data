package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.company.models.converter.CustomerConverter;
import com.company.models.domain.Customer;
import com.company.models.dto.CustomerDto;
import com.company.service.CustomerService;

import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomerList() {
        List<CustomerDto> responseCityDtoList = new ArrayList<>();
        for (Customer customer: customerService.getAll()) {
            responseCustomerDtoList.add(CustomerConverter.toDTO(customer));
        }
        return new ResponseEntity<>(responseCustomerDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Integer id) {
        try {
            Customer searchedCustomer = customerService.getById(id);
            return new ResponseEntity<>(CustomerConverter.toDTO(searchedCustomer), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> postCity(@RequestBody CustomerDto customerDto) {
        Customer createdCustomer = Customer.builder()
                .firstname(customerDto.getFirstName())
                .lastname(customerDto.getLastName())
                .email(customerService.getByEmail()
                .build();
        Customer responseCustomer = customerService.create(createdCustomer);
        return new ResponseEntity<>(CustomerConverter.toDTO(responseCustomer), HttpStatus.CREATED);
    }

}
