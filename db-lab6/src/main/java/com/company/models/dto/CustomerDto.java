package com.company.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
