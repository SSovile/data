package com.company.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@Table(name = "number")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberOfPhone {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", nullable = false, length = 45)
    private Integer number;

    @Override
    public String toString() {
        return String.format("Number id: %2d, Number: %s", id, number);
    }
}