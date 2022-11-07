package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "book_order", schema = "bookstoredb", catalog = "")
public class BookOrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
    @Basic
    @Column(name = "shipping_address", nullable = false, length = 256)
    private String shippingAddress;
    @Basic
    @Column(name = "recipient_name", nullable = false, length = 30)
    private String recipientName;
    @Basic
    @Column(name = "recipient_phone", nullable = false, length = 15)
    private String recipientPhone;
    @Basic
    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private double total;
    @Basic
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrderEntity that = (BookOrderEntity) o;
        return orderId == that.orderId && customerId == that.customerId && Double.compare(that.total, total) == 0 && Objects.equals(orderDate, that.orderDate) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(recipientName, that.recipientName) && Objects.equals(recipientPhone, that.recipientPhone) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderDate, shippingAddress, recipientName, recipientPhone, paymentMethod, total, status);
    }
}
