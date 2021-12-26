package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;
@Table(name = "home_address")
@Data
public class HomeAddress extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "street_id")
    private Integer streetId;
}