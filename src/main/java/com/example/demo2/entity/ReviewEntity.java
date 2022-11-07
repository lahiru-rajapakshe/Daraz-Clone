package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "review", schema = "bookstoredb", catalog = "")
public class ReviewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "review_id", nullable = false)
    private int reviewId;
    @Basic
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "rating", nullable = false)
    private int rating;
    @Basic
    @Column(name = "headline", nullable = false, length = 128)
    private String headline;
    @Basic
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;
    @Basic
    @Column(name = "review_time", nullable = false)
    private Timestamp reviewTime;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

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
        ReviewEntity that = (ReviewEntity) o;
        return reviewId == that.reviewId && bookId == that.bookId && customerId == that.customerId && rating == that.rating && Objects.equals(headline, that.headline) && Objects.equals(comment, that.comment) && Objects.equals(reviewTime, that.reviewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, bookId, customerId, rating, headline, comment, reviewTime);
    }
}
