package com.example.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="Customer")
public class Customer implements Serializable {
    @Id
    private int id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(columnDefinition = "VARCHAR(200)")
    private String address;
}
