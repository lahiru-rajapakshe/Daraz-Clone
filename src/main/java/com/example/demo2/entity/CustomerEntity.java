package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "bookstoredb", catalog = "")
public class CustomerEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "email", nullable = false, length = 64)
    private String email;
    @Basic
    @Column(name = "fullName", nullable = false, length = 30)
    private String fullName;
    @Basic
    @Column(name = "address", nullable = false, length = 128)
    private String address;
    @Basic
    @Column(name = "city", nullable = false, length = 32)
    private String city;
    @Basic
    @Column(name = "country", nullable = false, length = 64)
    private String country;
    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;
    @Basic
    @Column(name = "zipcode", nullable = false, length = 24)
    private String zipcode;
    @Basic
    @Column(name = "password", nullable = false, length = 16)
    private String password;
    @Basic
    @Column(name = "register_date", nullable = false)
    private Timestamp registerDate;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customerId == that.customerId && Objects.equals(email, that.email) && Objects.equals(fullName, that.fullName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone) && Objects.equals(zipcode, that.zipcode) && Objects.equals(password, that.password) && Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, fullName, address, city, country, phone, zipcode, password, registerDate);
    }
}
