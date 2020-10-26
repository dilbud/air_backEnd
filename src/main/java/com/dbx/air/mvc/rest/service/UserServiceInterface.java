package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.entity.User;

public interface UserServiceInterface {
    User getUser(String email, String password);
}
