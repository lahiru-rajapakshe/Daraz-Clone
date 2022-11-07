package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "bookstoredb", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "email", nullable = false, length = 30)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 16)
    private String password;
    @Basic
    @Column(name = "full_name", nullable = false, length = 30)
    private String fullName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
        UsersEntity that = (UsersEntity) o;
        return userId == that.userId && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, fullName);
    }
}
