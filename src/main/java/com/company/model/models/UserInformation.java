package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "user_information")
@Data
public class UserInformation extends GeneralModel{

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "palpitation")
    private Float palpitation;
}
