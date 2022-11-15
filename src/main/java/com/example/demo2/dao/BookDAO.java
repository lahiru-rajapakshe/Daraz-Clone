package com.example.demo2.dao;

import com.example.demo2.entity.Book;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {
    public BookDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Object get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Book create(Book book) {
        book.setLastUpdateTime(new Date());
        return super.create(book);
    }

    @Override
    public Book update(Book book) {
        book.setLastUpdateTime(new Date());
        return  super.update(book);
    }
}
