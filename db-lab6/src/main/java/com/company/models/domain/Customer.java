package com.company.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "customer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @ManyToOne
    @JoinColumn(name = "number_id", referencedColumnName = "id", nullable = false)
    private NumberOfPhone numberOfPhone;

    @Override
    public String toString() {
        return String.format("Customer id: %2d, Customer: %s, Customer: %s, Number: %s, %s", id, firstname, lastname, email, numberOfPhone.toString());
    }
}
