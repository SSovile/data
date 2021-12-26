package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "street")
@Data
public class Street extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
