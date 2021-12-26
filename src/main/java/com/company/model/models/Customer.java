package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "customer")
@Data
public class Customer extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;
}