package com.company.models.converter;

import com.company.models.domain.Producer;
import com.company.models.dto.ProducerDto;

public class ProducerConverter {
    public static ProducerDto toDTO(Producer producer) {
        return ProducerDto.builder()
                .id(producer.getId())
                .name(producer.getName())
                .brand(producer.getBrand())
                .email(producer.getEmail())
                .build();
    }
}
