package com.example.demo2.service;

import com.example.demo2.dao.ReviewDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ReviewService {
    private ReviewDAO reviewDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ReviewService(HttpServletRequest request, HttpServletResponse response) {
        super();
        this.request = request;
        this.response = response;
        this.reviewDAO= new ReviewDAO();

    }

    public void listAllReview(){

    }
}
