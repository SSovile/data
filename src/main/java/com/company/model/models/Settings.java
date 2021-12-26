package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "settings", schema = "settings")
public class Settings extends GeneralModel{
    private int User_id;
    private int homId;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

    @Basic
    @Column(name = "homId")
    public int  getHomId() {
        return homId;
    }

    public void setHomId(int homId) {
        this.homId = homId;
    }


    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Settings that = (Settings) a;
        return User_id == that.User_id && Objects.equals(homId, that.homId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(User_id,homId);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s |",User_id,homId);
    }
}
