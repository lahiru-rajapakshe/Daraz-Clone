package com.example.demo2.dao;

import com.example.demo2.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>{

    @Override
    public Category create(Category category) {
        return super.create(category);
    }

    @Override
    public Category update(Category category) {
        return super.update(category);
    }

    public CategoryDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Category get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<Category> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
