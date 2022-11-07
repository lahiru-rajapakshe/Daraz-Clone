package com.example.demo2;

import com.example.demo2.entity.Customer;
import com.example.demo2.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.io.Serializable;

public class CreateCustomer {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            session.beginTransaction();

            Customer customer = new Customer(31, "lakai sikai", "Emb");
//            session.save(customer);
            Serializable id = session.save(customer);
            System.out.println(id);

            session.getTransaction().commit();

        } catch (Throwable t) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }finally{
            session.close();
            sf.close();
        }
    }
}
