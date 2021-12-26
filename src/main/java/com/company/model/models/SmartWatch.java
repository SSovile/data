package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "smartWatch", schema = "smartWatch")
public class SmartWatch extends GeneralModel{
    private int id;
    private String model;
    private String Customer_id;
    private String charge;
    private String User_id;

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
    @Column(name = "model")
    public String  getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "customer_id")
    public String  getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String Customer_id) {
        this.Customer_id = Customer_id;
    }

    @Basic
    @Column(name = "charge")
    public String  getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Basic
    @Column(name = "user_id")
    public String  getUser_id() {
        return User_id;
    }

    public void setUser_id(String User_id) {
        this.User_id = User_id;
    }


    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        SmartWatch that = (SmartWatch) a;
        return id == that.id && Objects.equals(model, that.model) && Objects.equals(Customer_id, that.Customer_id) && Objects.equals(charge, that.charge) && Objects.equals(User_id, that.User_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,model,Customer_id,charge,User_id);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s |",id,model,Customer_id,charge,User_id);
    }
}
