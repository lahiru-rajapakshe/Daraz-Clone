package com.example.demo2.dao;

import com.example.demo2.entity.UsersEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<UsersEntity> implements GenericDAO<UsersEntity>{


    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public UsersEntity update(UsersEntity usersEntity) {
        return null;
    }

    @Override
    public UsersEntity get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<UsersEntity> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
