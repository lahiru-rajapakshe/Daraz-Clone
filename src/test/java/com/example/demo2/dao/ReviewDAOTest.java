package com.example.demo2.dao;

import com.example.demo2.entity.Book;
import com.example.demo2.entity.Customer;
import com.example.demo2.entity.Review;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDAOTest extends JpaDAO {
private static  ReviewDAO reviewDAO;

public  static void setupBeforeClass() throws Exception{
    reviewDAO= new ReviewDAO();
}

    public  static void tearDownAfterClass() throws Exception{
        reviewDAO.close();
    }


    @Test
    public void get(Review reviewId) {

Integer reviewId=1;
        Review review = reviewDAO.get(reviewId);
        assertNotNull(review);

    }

    @Test
    public void testCreate() {
        Review review = new Review();
        Book book = new Book();
        book.setBookId(23);

        Customer customer = new Customer();
        customer.setCustomerId(3);

        review.setBookId(book);
        review.setRating(5);
        review.setComment("Isuperb");

        Review savedReview = reviewDAO.create(review);

        assertTrue(savedReview.getReviewId()>0);



    }

    @Test
    void testDelete() {
    int reviewId=2;
    reviewDAO.delete(reviewId);
        Review review = reviewDAO.get(reviewId);
        assertNull(review);
    }

    @Test
    public void  testListAll() {
        List<Review> reviews = reviewDAO.listAll();
        assertTrue(reviews.size()>0);

     
    }

    @Test
    public void count() {
        long totalReviews = reviewDAO.count();
        System.out.println("Total values "+totalReviews);
        assertTrue(totalReviews>0);

        
    }

    @Test
    public void testUpdateReview(Object entity) {
        Integer reviewId=1;
        Review review = reviewDAO.get(reviewId);

        review.setHeadline("excellent book");
        Review updatedReview = reviewDAO.update(review);

        assertEquals(review.getHeadline(),updatedReview.getHeadline());



    }
}