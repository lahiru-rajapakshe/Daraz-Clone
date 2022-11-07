package com.example.demo2;

import com.example.demo2.entity.Dildara;
import com.example.demo2.entity.User;
import com.example.demo2.entity.lara;
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

//            lara customer = new lara(8,"malinda saho", "s",12);
////            session.save(customer);
//            Serializable id = session.save(customer);
//            System.out.println(id);



            User sd = new User(1,"lahiru@gmail.com", "sd", "1232");
            Serializable save = session.save(sd);
            System.out.println(save+" saved");
//

//                        r customer2 = new r(1, "lakai sikai", "Emb");
////            session.save(customer);
//            Serializable id2 = session.save(customer2);
//            System.out.println(id2);


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
