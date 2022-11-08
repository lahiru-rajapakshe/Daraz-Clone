package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "bookstoredb", catalog = "")
public class Customer {
    private Integer customerId;
    private String email;
    private String fullName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Timestamp registerDate;
    private Collection<BookOrder> bookOrdersByCustomerId;
    private Collection<Review> reviewsByCustomerId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "fullName", nullable = false, length = 30)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 64)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 15)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "zipcode", nullable = false, length = 24)
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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
    @Column(name = "register_date", nullable = false)
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
        Customer that = (Customer) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(email, that.email) && Objects.equals(fullName, that.fullName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(phone, that.phone) && Objects.equals(zipcode, that.zipcode) && Objects.equals(password, that.password) && Objects.equals(registerDate, that.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, fullName, address, city, country, phone, zipcode, password, registerDate);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<BookOrder> getBookOrdersByCustomerId() {
        return bookOrdersByCustomerId;
    }

    public void setBookOrdersByCustomerId(Collection<BookOrder> bookOrdersByCustomerId) {
        this.bookOrdersByCustomerId = bookOrdersByCustomerId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<Review> getReviewsByCustomerId() {
        return reviewsByCustomerId;
    }

    public void setReviewsByCustomerId(Collection<Review> reviewsByCustomerId) {
        this.reviewsByCustomerId = reviewsByCustomerId;
    }
}
