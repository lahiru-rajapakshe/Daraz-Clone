package com.example.demo2.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "order_detail", schema = "bookstoredb", catalog = "")
public class OrderDetailEntity {
    @Basic
    @Column(name = "order_id", nullable = true)
    private Integer orderId;
    @Basic
    @Column(name = "book_id", nullable = true)
    private Integer bookId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "subtotal", nullable = false, precision = 0)
    private double subtotal;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return quantity == that.quantity && Double.compare(that.subtotal, subtotal) == 0 && Objects.equals(orderId, that.orderId) && Objects.equals(bookId, that.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, bookId, quantity, subtotal);
    }
}
