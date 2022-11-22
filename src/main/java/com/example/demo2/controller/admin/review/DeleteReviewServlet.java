package com.example.demo2.controller.admin.review;

import com.example.demo2.service.ReviewService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "/admin/delete_review", value = "/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewService reviewService = new ReviewService(request, response);
        reviewService.deleteReview();
    }

}
