package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lara", schema = "bookstoredb", catalog = "")
public class LaraEntity {
    private Integer id;
    private String address;
    private Integer age;
    private String fullName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 255)
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
        LaraEntity that = (LaraEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(age, that.age) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, age, fullName);
    }
}
