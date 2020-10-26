package com.dbx.air.mvc.rest.dao;

import com.dbx.air.mvc.rest.entity.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
public class UserDAO implements UserDAOInterface{
    private static final ArrayList<User> users = new ArrayList<>();

    static {

//        System.out.println("call userDAO ");

        users.add(new User(1,"nimal", "nimal@gmail.com","nimal"));
        users.add(new User(2,"kamal","kamal@gmail.com","kamal"));
        users.add(new User(3,"sahan","sahan@gmail.com","sahan"));
        users.add(new User(4,"anuradha","anuradha@gmail.com","anuradha"));
        users.add(new User(5,"kalum","kalum@gmail.com","kalum"));
    }

    @Override
    public User getUser(String email, String password) {
        User user = users.stream()
                .filter(val -> val.getEmail().equals(email) & val.getPassword().equals(password) )
                .collect(Collectors.toList())
                .get(0);
        return new User(user);
    }

}
