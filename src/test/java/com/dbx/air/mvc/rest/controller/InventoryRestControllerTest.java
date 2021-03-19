package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.config.WebAppInitializer;
import com.dbx.air.mvc.rest.config.WebConfig;
import mockit.Tested;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, WebAppInitializer.class})
@WebAppConfiguration
public class InventoryRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Tested(fullyInitialized = true)
    private InventoryRestController inventoryRestController;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
//        this.mockMvc = MockMvcBuilders.standaloneSetup(inventoryRestController).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInventories() {
        try {

            mockMvc.perform(get("/dashboard/inventories?brandCtrl=any&typeCtrl=any&textCtrl=any&length=0&pageIndex=0&pageSize=6&previousPageIndex=0"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteInventories() {
        try {
            mockMvc.perform(delete("/dashboard/inventories/101?brandCtrl=any&typeCtrl=any&textCtrl=any&length=0&pageIndex=0&pageSize=6&previousPageIndex=0"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andDo(print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}