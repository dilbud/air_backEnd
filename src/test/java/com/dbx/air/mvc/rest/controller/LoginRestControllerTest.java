package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.config.WebAppInitializer;
import com.dbx.air.mvc.rest.config.WebConfig;
import com.dbx.air.mvc.rest.dao.InventoryDAO;
import com.dbx.air.mvc.rest.dao.UserDAO;
import com.dbx.air.mvc.rest.entity.User;
import com.dbx.air.mvc.rest.service.InventoryService;
import com.dbx.air.mvc.rest.service.InventoryServiceInterface;
import com.dbx.air.mvc.rest.service.UserService;
import com.dbx.air.mvc.rest.service.UserServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import mockit.Tested;
import mockit.integration.springframework.FakeBeanFactory;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, WebAppInitializer.class })
@WebAppConfiguration
public class LoginRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    @Tested(fullyInitialized = true)
    private LoginRestController loginRestController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders
//                .standaloneSetup(loginRestController)
//                .build();
                this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac). build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void login() throws Exception {

        User user = new User();
        user.setEmail("nimal@gmail.com");
        user.setPassword("nimal");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String userJson = ow.writeValueAsString(user);

        try {
            mockMvc.perform(
                    post("http://localhost:8080/login/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(userJson)
            ).andExpect(status().isOk());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}