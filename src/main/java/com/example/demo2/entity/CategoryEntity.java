package com.example.demo2.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "bookstoredb", catalog = "")
public class CategoryEntity {
    private Integer categoryId;
    private String name;
    private Collection<BookEntity> booksByCategoryId;

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
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(categoryId, that.categoryId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<BookEntity> getBooksByCategoryId() {
        return booksByCategoryId;
    }

    public void setBooksByCategoryId(Collection<BookEntity> booksByCategoryId) {
        this.booksByCategoryId = booksByCategoryId;
    }
}
