package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "smartWatch")
@Data
public class SmartWatch extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "model")
    private String model;

    @Column(name = "Customer_id")
    private String customerId;

    @Column(name = "charge")
    private String charge;

    @Column(name = "User_id")
    private String userId;
}
