package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "street", schema = "street")
public class Street extends GeneralModel{
    private int id;
    private String name;

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
    @Column(name = "name")
    public String  getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Street that = (Street) a;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s |",id,name);
    }
}