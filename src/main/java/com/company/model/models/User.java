package com.company.model.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "user")
public class User extends GeneralModel{
    private int id;
    private String nickname;

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
    @Column(name = "nickname")
    public String  getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        User that = (User) a;
        return id == that.id && Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nickname);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s |",id,nickname);
    }
}