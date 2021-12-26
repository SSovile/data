package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "city")
public class City extends GeneralModel{
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,name);
    }
}
