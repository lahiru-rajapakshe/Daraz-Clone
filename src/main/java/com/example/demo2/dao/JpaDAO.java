package com.example.demo2.dao;

import com.example.demo2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaDAO<E> {
    private static EntityManagerFactory entityManagerFactory;
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
    }
    SessionFactory sf = HibernateUtil.getSessionFactory();
    Session session = sf.openSession();


    public JpaDAO() {

    }


    public E create(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        session.beginTransaction();
        session.save(entity);
        session.flush();
        session.refresh(entity);
        session.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public E update(E entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        session.beginTransaction();
        Object merge = session.merge(entity);
        session.getTransaction().commit();
        entityManager.close();
        return entity;
    }

    public E find(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        E entity = session.find(type, id);
        if (entity != null) {
            session.refresh(entity);
        }
        entityManager.close();

        return entity;
    }

    public void delete(Class<E> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        session.getTransaction().begin();
        E reference = session.getReference(type, id);
        session.remove(reference);

        session.getTransaction().commit();

        entityManager.close();

    }

    public List<E> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = session.createNamedQuery(queryName);
        List<E> result = query.getResultList();
        entityManager.close();
        return result;


    }
    public List<E> findWithNamedQuery(String queryName,int firtsResult,int maxResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = session.createNamedQuery(queryName);
        query.setFirstResult(firtsResult);
        query.setMaxResults(maxResult);
        List<E> result = query.getResultList();
        entityManager.close();
        return result;


    }

    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = session.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        List<E> result = query.getResultList();
        entityManager.close();
        return result;
    }

    public List<E> findWithNamedQuery(String queryName,Map<String, Object> parameters) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = session.createNamedQuery(queryName);
        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();

        for (Map.Entry<String,Object> entry:setParameters){

            query.setParameter(entry.getKey(), entry.getValue());
        }

        List<E> result = query.getResultList();
        entityManager.close();
        return result;
    }



    public long contWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = session.createNamedQuery(queryName);

        long  result=(long) query.getSingleResult();
        entityManager.close();

        return result;


    }
}
