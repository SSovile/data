package com.company.models.converter;

import com.company.models.domain.NumberOfPhone;
import com.company.models.dto.NumberOfPhoneDto;

public class NumberOfPhoneConverter {
    public static NumberOfPhoneDto toDTO(NumberOfPhone numberOfPhone) {
        return NumberOfPhoneDto.builder()
                .id(numberOfPhone.getId())
                .number(numberOfPhone.getNumber())
                .build();
    }
}
