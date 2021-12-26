package com.company.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nickname", nullable = false, length = 45)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "number_id", referencedColumnName = "id", nullable = false)
    private NumberOfPhone numberOfPhone;

    @Override
    public String toString() {
        return String.format("User id: %2d, User: %s, Number: %s", id, nickname, numberOfPhone);
    }
}
