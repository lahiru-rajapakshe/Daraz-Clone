package com.example.demo2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class lara implements Serializable {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(columnDefinition = "VARCHAR(200)")
    private String address;
    @Column(columnDefinition = "INT(11)")
    private int age;
}
