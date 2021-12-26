package com.company.models.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@Table(name = "producer")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "brand", nullable = false, length = 45)
    private String brand;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Override
    public String toString() {
        return String.format("Producer id: %2d, Producer: %s, Brand: %s, Email: %s", id, name, brand, email);
    }
}
