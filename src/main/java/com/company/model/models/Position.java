package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "position", schema = "position")
public class Position extends GeneralModel{
    private int id;
    private String length;
    private String width;

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
    @Column(name = "length")
    public String  getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    @Basic
    @Column(name = "width")
    public String  getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Position that = (Position) a;
        return id == that.id && Objects.equals(length, that.length) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,length,width);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,length,width);
    }
}