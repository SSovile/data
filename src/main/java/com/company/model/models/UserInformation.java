package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "userInformation", schema = "userInformation")
public class UserInformation extends GeneralModel{
    private int id;
    private int position_id;
    private Float palpitation;

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
    @Column(name = "position_id")
    public int  getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    @Basic
    @Column(name = "palpitation")
    public Float  getPalpitation() {
        return palpitation;
    }

    public void setPalpitation(float palpitation) {
        this.palpitation = palpitation;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        UserInformation that = (UserInformation) a;
        return id == that.id && Objects.equals(position_id, that.position_id) && Objects.equals(palpitation, that.palpitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,position_id,palpitation);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,position_id,palpitation);
    }
}
