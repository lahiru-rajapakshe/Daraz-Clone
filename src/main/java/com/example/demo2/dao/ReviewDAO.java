package com.example.demo2.dao;

import com.example.demo2.entity.Review;

import java.util.List;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
    @Override
    public Review get(Object id) {
        return null;
    }

    @Override
    public Review create(Review entity) {
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<Review> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
