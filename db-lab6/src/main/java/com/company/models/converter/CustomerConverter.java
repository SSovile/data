package com.company.models.converter;

import com.company.models.domain.Customer;
import com.company.models.dto.CustomerDto;

public class CustomerConverter {
    public static CustomerDto toDTO(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstName())
                .lastname(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
