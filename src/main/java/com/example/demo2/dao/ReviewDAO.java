package com.example.demo2.dao;

import com.example.demo2.entity.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewDAO extends JpaDAO<Review> implements GenericDAO<Review> {
    @Override
    public Review get(Object reviewId) {
        return super.find(Review.class, reviewId)
    }

    @Override
    public Review create(Review entity) {
    }

    @Override
    public void delete(Object reviewId) {
        super.delete(Review.class, reviewId);

    }

    @Override
    public List<Review> listAll() {
        return super.findWithNamedQuery("Review.listAll");
    }

    @Override
    public long count() {

        return super.contWithNamedQuery("Review.countAll");
    }

public Review findByCustomerAnBook(Integer customerId,Integer bookId){
    Map<String, Object> parameters= new HashMap<>();
    parameters.put("customerId",customerId);
    parameters.put("bookId",bookId);

    List<Review> result = super.findWithNamedQuery("Review.findByCustomerAndBook", parameters);
    if(!result.isEmpty()){
        return  result.get(0);
    }
    return null;

}
}
