package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "bookstoredb", catalog = "")
@NamedQueries({
        @NamedQuery(name ="Review.listAll" ,query = "SELECT r FROM Review ORDER BY r.reviewTime DESC"),
        @NamedQuery(name ="Review.countAll" ,query = "SELECT Count(r) FROM Review r")
})
public class Review {
    private Integer reviewId;
    private Integer bookId;
    private Integer customerId;
    private Integer rating;
    private String headline;
    private String comment;
    private Timestamp reviewTime;
    private Book bookByBookId;
    private Customer customerByCustomerId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "book_id", nullable = false)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "customer_id", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "headline", nullable = false, length = 128)
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 500)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "review_time", nullable = false)
    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review that = (Review) o;
        return Objects.equals(reviewId, that.reviewId) && Objects.equals(bookId, that.bookId) && Objects.equals(customerId, that.customerId) && Objects.equals(rating, that.rating) && Objects.equals(headline, that.headline) && Objects.equals(comment, that.comment) && Objects.equals(reviewTime, that.reviewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, bookId, customerId, rating, headline, comment, reviewTime);
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
