package com.example.demo2.service;

import com.example.demo2.dao.BookDAO;
import com.example.demo2.dao.ReviewDAO;
import com.example.demo2.entity.Book;
import com.example.demo2.entity.Review;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ReviewService {
    private ReviewDAO reviewDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ReviewService(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
        this.reviewDAO = new ReviewDAO();

    }

    //    public void listAllReview() throws ServletException, IOException {
//        List<Review> reviews =reviewDAO.listAll();
//        request.setAttribute("listReviews",reviews);
//
//
//        String listPage="review_list.jsp";
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
//        requestDispatcher.forward(request,response);
//
//
//    }
    public void listAllReview(String message) throws ServletException, IOException {
        List<Review> reviews = reviewDAO.listAll();
        request.setAttribute("listReviews", reviews);

        if (message != null) {
            request.setAttribute("message", message);
        }
        String listPage = "review_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request, response);


    }

    public void listAllReview() throws ServletException, IOException {
        listAllReview(null);
    }


    public void editReview() throws ServletException, IOException {
        Integer reviewId = Integer.parseInt(request.getParameter("id"));
        Review review = reviewDAO.get(reviewId);
        request.setAttribute("review", review);

        String editPage = "review_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request, response);

    }

    public void updateReview() throws ServletException, IOException {
        Integer reviewId = Integer.parseInt(request.getParameter("reviewId"));
        String headline = request.getParameter("headline");
        String comment = request.getParameter("comment");

        Review review = reviewDAO.get(reviewId);
        review.setHeadline(headline);
        review.setComment(comment);

        reviewDAO.update(review);

        String message = "the review has been updated seccessfully !";

        listAllReview(message);
    }

    public void deleteReview() throws ServletException, IOException {
        Integer reviewId = Integer.parseInt(request.getParameter("id"));
        reviewDAO.delete(reviewId);
        String message = "The review deleted successfully !";

        listAllReview(message);

    }

    public void showReviewForm() throws ServletException, IOException {
        Integer book_id = Integer.parseInt(request.getParameter("book_id"));
        BookDAO bookDAO = new BookDAO();
        bookDAO.get(book_id)

        String targetPage="frontend/review_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(targetPage);
        requestDispatcher.forward(request,response);

    }

    public void submitReview() {
        Integer book_id = Integer.parseInt(request.getParameter("book_id"));
        Integer rating = Integer.parseInt(request.getParameter("rating"));
        String headline = request.getParameter("headline");
        String comment = request.getParameter("comment");

        Review review = new Review();
        review.setHeadline(headline);
        review.setComment(comment);
        review.setRating(rating);

        Book book = new Book();
        book.setBookId(book_id);




    }
}
