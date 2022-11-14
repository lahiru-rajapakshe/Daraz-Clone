package com.example.demo2.dao;

import com.example.demo2.entity.Users;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {


    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);


    }

    @Override
    public Users get(Object userId) {
        return find(Users.class, userId);
    }

    @Override
    public void delete(Object userId) {
        super.delete(Users.class, userId);
    }

    @Override
    public List<Users> listAll() {

        return super.findWithNamedQuery("Users.findAll");

    }

    @Override
    public long count() {

        return super.contWithNamedQuery("Users.countAll");
    }

    @Override
    public Users create(Users users) {
        return super.create(users);
    }

    public Users findByEmail(String email) {
        List<Users> listUsers = super.findWithNamedQuery("Users.findByEmail", "email", email);

        if(listUsers != null && listUsers.size() >0 ){
            return  listUsers.get(0);
        }
        return  null;
        
        
        

    }
    public boolean checkLogin(String email,String password){
        Map<String,Object> parameters=new HashMap<>();
        parameters.put("email",email);
        parameters.put("password",password);

        List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
        if(listUsers.size()==1){
            return  true;
        }


        return false;
    }

}
