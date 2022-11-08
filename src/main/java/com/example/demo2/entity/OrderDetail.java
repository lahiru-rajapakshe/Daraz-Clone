package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_detail", schema = "bookstoredb", catalog = "")
public class OrderDetail {
    private Integer orderId;
    private Integer bookId;
    private Integer quantity;
    private Double subtotal;
    private BookOrder bookOrderByOrderId;
    private Book bookByBookId;

    @Basic
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "book_id", nullable = true)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "quantity", nullable = false)
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "subtotal", nullable = false, precision = 0)
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(bookId, that.bookId) && Objects.equals(quantity, that.quantity) && Objects.equals(subtotal, that.subtotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, bookId, quantity, subtotal);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    public BookOrder getBookOrderByOrderId() {
        return bookOrderByOrderId;
    }

    public void setBookOrderByOrderId(BookOrder bookOrderByOrderId) {
        this.bookOrderByOrderId = bookOrderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }
}
