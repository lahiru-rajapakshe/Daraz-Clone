package com.example.demo2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "bookstoredb")
@NamedQueries({
        @NamedQuery(name = "Book.findAll",query = "SELECT b FROM  Book b"),
        @NamedQuery(name = "Book.findAll",query = "SELECT b FROM  Book b WHERE b.title =: title"),
        @NamedQuery(name = "Book.findAll",query = "SELECT COUNT(*) FROM  Book b "),
})
public class Book {
    private Integer bookId;
    private String book;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String base64Image;
    private String title;
    private String description;
    private String isbn;
    private byte[] image;
    private Double price;
    private Date publishDate;
    private Date lastUpdateTime;
    private Integer categoryId;
    private Category categoryByCategoryId;
    private Collection<OrderDetail> orderDetailsByBookId;
    private Collection<Review> reviewsByBookId;

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
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(java.util.Date lastUpdateTime) {
        this.lastUpdateTime = (Date) lastUpdateTime;
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
        Book that = (Book) o;
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
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<OrderDetail> getOrderDetailsByBookId() {
        return orderDetailsByBookId;
    }

    public void setOrderDetailsByBookId(Collection<OrderDetail> orderDetailsByBookId) {
        this.orderDetailsByBookId = orderDetailsByBookId;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<Review> getReviewsByBookId() {
        return reviewsByBookId;
    }

    public void setReviewsByBookId(Collection<Review> reviewsByBookId) {
        this.reviewsByBookId = reviewsByBookId;
    }

@Transient
    public String getBase64Image(){
      this.base64Image=Base64.getEncoder().encodeToString(this.image);
      return this.base64Image;
    }
@Transient
    public void setBase64Image(String base64Image){
this.base64Image=base64Image;
    }
}
