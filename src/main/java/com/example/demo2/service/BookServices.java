package com.example.demo2.service;

import com.example.demo2.dao.BookDAO;
import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.entity.Book;
import com.example.demo2.entity.Category;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookServices {
  private EntityManager entityManager;
  private HttpServletRequest request;
  private HttpServletResponse response;
  private CategoryDAO categoryDAO;
  private BookDAO bookDAO;


    public BookServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

        this.entityManager = entityManager;
        this.request = request;
        this.response = response;

        bookDAO = new BookDAO(entityManager);
        categoryDAO = new CategoryDAO(entityManager);
    }
    public void listBooks() throws ServletException, IOException{
        listBooks(null);
    }
    public void listBooks(String message) throws ServletException, IOException {
        List<BookDAO> listBooks =bookDAO.listAll();
        request.setAttribute("listBooks",listBooks);

        if(message != null){
            request.setAttribute("message", message);

        }
        String listPage="book_list.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
        requestDispatcher.forward(request,response);



    }

    public void showBookNewForm() throws ServletException, IOException {
        List<Category> listCategories =categoryDAO.listAll();
        request.setAttribute("listCategories",listCategories);

        String newPage="book_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(newPage);
        requestDispatcher.forward(request,response);



    }

    public void createBook() throws ServletException, IOException {
        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        String isbn = request.getParameter("isbn");
        Float price = Float.parseFloat(request.getParameter("price"));

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate=null;
        try {
            publishDate = dateFormat.parse(request.getParameter("publishDate"));

        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServletException("Error parsing publish date (format is MM/dd/yyyy)");

        }

        Book newBook = new Book();
        newBook.setTitle(title);

        Book existBook = bookDAO.findByTitle(title);
        if(existBook != null){
            String message="could not create a new book because this title already exists !";
            listBooks(message);
            request.setAttribute("message",message);
            return;

        }

        newBook.setAuthor(author);
        newBook.setDescription(description);
        newBook.setIsbn(isbn);
        newBook.setPublishDate((java.sql.Date) publishDate);

        Category category = categoryDAO.get(categoryId);
        newBook.setCategoryByCategoryId(category);

        newBook.setPrice(Double.valueOf(price));




        Part part = request.getPart("bookImage");
        if(part != null && part.getSize()>0){
            long size =part.getSize();
            byte[] imageBytes= new byte[(int) size];

            InputStream inputStream = part.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();

            newBook.setImage(imageBytes);
        }
        Book createdBook = bookDAO.create(newBook);
        if(createdBook.getBookId()>0){
//            System.out.println();
            String message=" A book has been created successfully !";
//            request.setAttribute("message", message);

            listBooks(message);
        }


    }

    public void editBook() throws ServletException, IOException {
        Integer bookId = Integer.valueOf(request.getParameter("id"));
        Book book = bookDAO.get(bookId);
        List<Category> listCategories = categoryDAO.listAll();

        

        request.setAttribute("book",book);
        request.setAttribute("listCategories",book);


String editPage="book_form.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
        requestDispatcher.forward(request,response);

    }

    public void updateBook() {
        
    }
}
