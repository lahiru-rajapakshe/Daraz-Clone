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
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM  Book b"),
        @NamedQuery(name = "Book.findAll", query = "SELECT b FROM  Book b WHERE b.title =: title"),
        @NamedQuery(name = "Book.findAll", query = "SELECT COUNT(*) FROM  Book b "),
        @NamedQuery(name = "Book.findByCategory",query = "SELECT b FROM Book b JOIN Category c ON b.category.categoryId=c.categoryId AND c.categoryId =:catId")
        @NamedQuery(name = "Book.listNew",query = "SELECT b FROM Book b ORDER BY b.publishDate DESC"),
        @NamedQuery(name = "Book.search",query = "SELECT b FROM Book b WHERE b.title LIKE '%' || :keyword || '%' OR b.author LIKE '%' || :keyword || '%' OR b.description  LIKE '%' || :keyword || '%' ")
        @NamedQuery(name = "Book.countByCategory",query = "SELECT COUNT(b) FROM Book b JOIN Category c ON b.categoryId=c.categoryId AND c.categoryId =:catId"),

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

    @ManyToOne(fetch = FetchType.EAGER)
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
    public String getBase64Image() {
        this.base64Image = Base64.getEncoder().encodeToString(this.image);
        return this.base64Image;
    }

    @Transient
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book1 = (Book) o;
        return Objects.equals(bookId, book1.bookId) && Objects.equals(book, book1.book) && Objects.equals(author, book1.author) && Objects.equals(base64Image, book1.base64Image) && Objects.equals(title, book1.title) && Objects.equals(description, book1.description) && Objects.equals(isbn, book1.isbn) && Arrays.equals(image, book1.image) && Objects.equals(price, book1.price) && Objects.equals(publishDate, book1.publishDate) && Objects.equals(lastUpdateTime, book1.lastUpdateTime) && Objects.equals(categoryId, book1.categoryId) && Objects.equals(categoryByCategoryId, book1.categoryByCategoryId) && Objects.equals(orderDetailsByBookId, book1.orderDetailsByBookId) && Objects.equals(reviewsByBookId, book1.reviewsByBookId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, book, author, base64Image, title, description, isbn, price, publishDate, lastUpdateTime, categoryId, categoryByCategoryId, orderDetailsByBookId, reviewsByBookId);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Transient
    public float getAvarageRating(){
        float avarageRating=0.0f;
        float sum = 0.0f;

        if(reviews.isempty()){
            return 0.0f;
        }

        for (Review review:reviews
             ) {
            sum+= review.getRating();
            
        }
        avarageRating=sum/reviews.size();
        return avarageRating;


    }

    @Transient
    public String getRatingString(float avarageRating){
        String result="";
        int numberOfStartsOn= (int) avarageRating;
        for (int i = 1; i <=numberOfStartsOn ; i++) {
            result+= "on,";

        }
        int next =numberOfStartsOn+1;
        if(avarageRating>numberOfStartsOn){
            result+="half,";
            next++;
        }

        for (int i = next; i <=5 ; i++) {
            result+="off,";
            
        }
        return  result;

    }

    @Transient
    public String getratingStarts(){
        float avarageRating= getAvarageRating();

        return getRatingString(avarageRating);

    }
}
