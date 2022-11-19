package com.example.demo2.dao;

import com.example.demo2.entity.Customer;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class CustomerDAO extends JpaDAO<Customer> implements GenericDAO<Customer> {
    @Override
    public Customer create(Customer customer) {
        customer.setRegisterDate((Timestamp) new Date());
        return super.create(customer);
    }

    @Override
    public Customer get(Object id) {
        return super.find(Customer.class, id);
    }

    @Override
    public void delete(Object id) {
        super.delete(Customer.class, id);
    }

    @Override
    public List listAll() {

        return super.findWithNamedQuery("Customer.findAll");
    }

    @Override
    public long count() {
        return         return super.contWithNamedQuery("Customer.countAll");
    }
}
