package com.example.demo2.dao;

import com.example.demo2.entity.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest extends JpaDAO {

    private static CustomerDAO customerDAO;

    @Test
    public static void setupBeforeClass() throws Exception{
        customerDAO=new CustomerDAO();
    }

    @Test
    public static void tearDownClass() throws Exception{
       customerDAO.close();
    }


    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customer.setEmail("lahiru@gmail.com");
        customer.setFullName("lahiya");
        customer.setCity("emb");
        customer.setAddress("new york");
        customer.setAddress("dontt know");
        customer.setPassword("secret");
        customer.setPhone("7826376");
        customer.setZipcode("234");

        Customer savedCustomer = customerDAO.create(customer);
        assertTrue(savedCustomer.getCustomerId()>0);

    }

    @Test
    public void get() {
        Integer customerId=1;
        Customer customer = customerDAO.get(customerId);
        assertNotNull(customer);


    }

    @Test
    public void testUpdate(){
               Customer customer=customerDAO.get(1);
               customer.setFullName("sajhgdjhag");
               customerDAO.update(customer);

    }

    @Test
    void testDelete() {
    }

    @Test
    void listAll() {
    }

    @Test
    void count() {
    }
}