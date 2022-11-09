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
    public Users get(Object userId)
    {
        return find(Users.class,userId);
    }

    @Override
    public void delete(Object userId) {
super.delete(Users.class,userId);
    }

    @Override
    public List<Users> listAll() {

        return  super.findWithNamedQuery("Users.findAll");
    }

    @Override
    public long count() {

        super.findWithNamedQuery("Users.countAll");
    }

    @Override
    public Users create(Users users) {
        return super.create(users);
    }
}
