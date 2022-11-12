package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "bookstoredb", catalog = "")
@NamedQueries({
        @NamedQuery(name = "Category.findAll",query = "SELECT c FROM Category c ORDER BY c.name"),
        @NamedQuery(name = "Category.countAll",query = "SELECT COUNT(*) FROM Category "),
        @NamedQuery(name = "Category.findByName",query = "SELECT c FROM Category c WHERE c.name =:name")


})
public class Category {
    private Integer categoryId;
    private String name;
    private Collection<Book> booksByCategoryId;

    public Category() {
    }

    public Category(Integer categoryId, String name, Collection<Book> booksByCategoryId) {
        this.categoryId = categoryId;
        this.name = name;
        this.booksByCategoryId = booksByCategoryId;
    }

    public Category(String name) {

        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Book> getBooksByCategoryId() {
        return booksByCategoryId;
    }

    public void setBooksByCategoryId(Collection<Book> booksByCategoryId) {
        this.booksByCategoryId = booksByCategoryId;
    }
}
