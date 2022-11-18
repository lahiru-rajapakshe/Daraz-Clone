package com.example.demo2.dao;

import com.example.demo2.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {
    public BookDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Book get(Object bookId) {

        return super.find(Book.class, bookId);
    }

    @Override
    public void delete(Object bookId) {
        super.delete(Book.class, bookId);

    }

    @Override
    public List<BookDAO> listAll() {
        return super.findWithNamedQuery("Book.findAll");
    }

    @Override
    public long count() {
        return super.contWithNamedQuery("Book.countAll");
    }

    @Override
    public Book create(Book book) {
        book.setLastUpdateTime(new Date());
        return super.create(book);
    }

    @Override
    public Book update(Book book) {
        book.setLastUpdateTime(new Date());
        return super.update(book);
    }

    public Book findByTitle(String title) {
        List<Book> result = super.findWithNamedQuery("Book.findByTitle", "title", title);

        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;

    }

    public List<Book> listByCategory(int categoryId) {
        return super.findWithNamedQuery("Book.findByCategory", "catId", categoryId);


    }

    public List<Book> listNewBooks() {
        Query namedQuery = entityManager.createNamedQuery("Book.listNew");
        namedQuery.setFirstResult(0);
        namedQuery.setMaxResults(4);

        return super.findWithNamedQuery("Book.listNew",0,4);


    }

    public List<Book> search(String keyword){
        return  super.findWithNamedQuery("Book.search","keyword",keyword);

    }

    public long countByCategory(int categoryId){
   return  super.countWithNamedQuery("Book.countByCategory","catId",categoryId);
    }
}
