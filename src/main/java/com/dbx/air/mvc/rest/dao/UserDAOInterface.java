package com.dbx.air.mvc.rest.dao;

import com.dbx.air.mvc.rest.entity.User;

public interface UserDAOInterface {
    User getUser(String email, String password);
}
