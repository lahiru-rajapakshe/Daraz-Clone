package com.example.demo2.dao;

import com.example.demo2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class JpaDAO<E> {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();
    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
    }


    public E create(E entity) {
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.refresh(entity);
        session.getTransaction().commit();
        return entity;
    }

    public E update(E entity) {
        session.beginTransaction();
        Object merge = session.merge(entity);
        session.getTransaction().commit();

        return entity;
    }

    public E find(Class<E> type,Object id ){
        E entity = session.find(type, id);
        session.refresh(entity);
        return entity;
    }

}
