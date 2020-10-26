package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.config.WebAppInitializer;
import com.dbx.air.mvc.rest.config.WebConfig;
import com.dbx.air.mvc.rest.dao.UserDAO;
import com.dbx.air.mvc.rest.dao.UserDAOInterface;
import com.dbx.air.mvc.rest.entity.User;
import mockit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, WebAppInitializer.class })
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    @Tested(fullyInitialized = true)
    private UserServiceInterface userService;

    @Injectable
    private UserDAOInterface userDAO;

    @Before
    public void setUp() throws Exception {
        userDAO = new UserDAO();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUser() {
        new Expectations() {{
            userDAO.getUser("nimal@gmail.com", "nimal");
            result = new User();
        }};
    }

}