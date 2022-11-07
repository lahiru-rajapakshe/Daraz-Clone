package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Customerv", schema = "bookstoredb", catalog = "")
public class CustomervEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "address", nullable = true, length = 200)
    private String address;
    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;
    @Basic
    @Column(name = "full_name", nullable = false, length = 255)
    private String fullName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
        CustomervEntity that = (CustomervEntity) o;
        return id == that.id && Objects.equals(address, that.address) && Objects.equals(age, that.age) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, age, fullName);
    }
}
