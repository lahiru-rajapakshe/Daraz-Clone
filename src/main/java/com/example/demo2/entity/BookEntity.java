package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "bookstoredb", catalog = "")
public class BookEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "book_id", nullable = false)
    private int bookId;
    @Basic
    @Column(name = "book", nullable = false, length = 128)
    private String book;
    @Basic
    @Column(name = "author", nullable = false, length = 64)
    private String author;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "isbn", nullable = false, length = 15)
    private String isbn;
    @Basic
    @Column(name = "image", nullable = false)
    private byte[] image;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "publish_date", nullable = false)
    private Date publishDate;
    @Basic
    @Column(name = "last_update_time", nullable = false)
    private Timestamp lastUpdateTime;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return bookId == that.bookId && Double.compare(that.price, price) == 0 && categoryId == that.categoryId && Objects.equals(book, that.book) && Objects.equals(author, that.author) && Objects.equals(description, that.description) && Objects.equals(isbn, that.isbn) && Arrays.equals(image, that.image) && Objects.equals(publishDate, that.publishDate) && Objects.equals(lastUpdateTime, that.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, book, author, description, isbn, price, publishDate, lastUpdateTime, categoryId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
