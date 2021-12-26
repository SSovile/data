package com.company.model.models;

import com.company.model.models.annotation.Column;
import com.company.model.models.annotation.PrimaryKey;
import com.company.model.models.annotation.Table;
import lombok.Data;

@Table(name = "user")
@Data
public class User extends GeneralModel{
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;
}
