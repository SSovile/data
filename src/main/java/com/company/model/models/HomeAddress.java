package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "homeAddress", schema = "homeAddress")
public class HomeAddress extends GeneralModel{
    private int id;
    private int city_id;
    private int number;
    private int street_id;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city_id")
    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "street_id")
    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        HomeAddress that = (HomeAddress) a;
        return id == that.id && Objects.equals(city_id, that.city_id) && Objects.equals(number, that.number) && Objects.equals(street_id, that.street_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,city_id,number,street_id);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,city_id,number,street_id);
    }
}
