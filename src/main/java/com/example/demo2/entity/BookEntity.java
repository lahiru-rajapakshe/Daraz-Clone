package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "bookstoredb", catalog = "")
public class BookEntity {
    private Integer bookId;
    private String book;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private Double price;
    private Date publishDate;
    private Timestamp lastUpdateTime;
    private Integer categoryId;
    private CategoryEntity categoryByCategoryId;
    private Collection<OrderDetailEntity> orderDetailsByBookId;
    private Collection<ReviewEntity> reviewsByBookId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id", nullable = false)
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "book", nullable = false, length = 128)
    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Basic
    @Column(name = "author", nullable = false, length = 64)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isbn", nullable = false, length = 15)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "image", nullable = false)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "publish_date", nullable = false)
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "last_update_time", nullable = false)
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(book, that.book) && Objects.equals(author, that.author) && Objects.equals(description, that.description) && Objects.equals(isbn, that.isbn) && Arrays.equals(image, that.image) && Objects.equals(price, that.price) && Objects.equals(publishDate, that.publishDate) && Objects.equals(lastUpdateTime, that.lastUpdateTime) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, book, author, description, isbn, price, publishDate, lastUpdateTime, categoryId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<OrderDetailEntity> getOrderDetailsByBookId() {
        return orderDetailsByBookId;
    }

    public void setOrderDetailsByBookId(Collection<OrderDetailEntity> orderDetailsByBookId) {
        this.orderDetailsByBookId = orderDetailsByBookId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<ReviewEntity> getReviewsByBookId() {
        return reviewsByBookId;
    }

    public void setReviewsByBookId(Collection<ReviewEntity> reviewsByBookId) {
        this.reviewsByBookId = reviewsByBookId;
    }
}
