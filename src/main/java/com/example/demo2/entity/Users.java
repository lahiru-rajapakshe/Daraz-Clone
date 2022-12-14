package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "users", schema = "bookstoredb")
@NamedQueries(
        {
                @NamedQuery(name = "Users.findAll", query= "SELECT u FROM  Users u ORDER BY u.fullName "),
                @NamedQuery(name = "Users.countAll", query = "SELECT Count(*) FROM Users u"),
                @NamedQuery(name = "Users.findByEmail",query = "SELECT u FROM Users u WHERE u.email=:email"),
                @NamedQuery(name = "Users.checkLogin",query = "SELECT u FROM Users u WHERE u.email=:email AND password = :password")


        }
)
public class Users {
    @Column(name = "user_id")
    private Integer userId;
    private String email;
    private String password;
    @Column(name = "full_name")
    private String fullName;

    public Users() {
    }

    public Users(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public Users(Integer userId, String email, String password, String fullName) {
        this(email,fullName,password);
        this.userId = userId;

    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 30)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users that = (Users) o;
        return Objects.equals(userId, that.userId) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, fullName);
    }
}
