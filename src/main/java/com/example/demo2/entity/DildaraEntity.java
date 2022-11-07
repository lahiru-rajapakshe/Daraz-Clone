package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Dildara", schema = "bookstoredb", catalog = "")
public class DildaraEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
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
        DildaraEntity that = (DildaraEntity) o;
        return id == that.id && Objects.equals(age, that.age) && Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, fullName);
    }
}
