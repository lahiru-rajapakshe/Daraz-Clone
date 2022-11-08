package com.example.demo2;

import com.example.demo2.entity.LaraEntity;
import com.example.demo2.entity.Users;
import com.example.demo2.entity.lara;
import com.example.demo2.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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



//            User sd = new User(1,"lahiru@gmail.com", "sd", "1232");
//            Serializable save = session.save(sd);
//            System.out.println(save+" saved");
//

//                        r customer2 = new r(1, "lakai sikai", "Emb");
////            session.save(customer);
//            Serializable id2 = session.save(customer2);
//            System.out.println(id2);

//
//            lara lara = new lara(13, "jpa", "pink", 11);
//            session.save(lara);
//            System.out.println(lara);

//            LaraEntity laraEntity = new LaraEntity(29, "dsjh", 124, "Hibernate");
//            session.save(laraEntity);
//            System.out.println(laraEntity);

            Users users = new Users(1, "email", "22", "lahata");
            session.save(users);
            System.out.println(users);

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
