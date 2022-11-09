package com.example.demo2.dao;

import com.example.demo2.entity.Users;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>{


    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);


    }

    @Override
    public static Users get(Object userId)
    {
        return super.find(Users.class,userId);
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<Users> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Users create(Users users) {
        return super.create(users);
    }
}
