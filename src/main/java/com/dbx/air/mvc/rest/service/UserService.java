package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.dao.UserDAOInterface;
import com.dbx.air.mvc.rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface{

    private final UserDAOInterface userDAO;

    @Autowired
    public UserService(UserDAOInterface userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(String email, String password){
        return userDAO.getUser(email, password);
    }


}
