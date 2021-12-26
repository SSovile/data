package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "settings")
@Data
public class Settings extends GeneralModel{
    @PrimaryKey
    @Column(name = "User_id")
    private Integer userId;

    @Column(name = "home_address_id")
    private Integer homId;
}