package com.example.demo2.dao;

import com.example.demo2.entity.Category;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

    @Override
    public Category create(Category category) {
        return super.create(category);
    }

    @Override
    public Category update(Category category) {
        return super.update(category);
    }

    public CategoryDAO() {

    }

    @Override
    public Category get(Object id) {
        return super.find(Category.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Category.class, id);

    }

    @Override
    public List<Category> listAll() {
        return super.findWithNamedQuery("Category.findAll");
    }

    @Override
    public long count() {
        return super.contWithNamedQuery("Category.countAll");

    }

    public Category findByName(String categoryName) {
        List<Category> result = super.findWithNamedQuery("Category.findByName", "name", categoryName);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }
}
