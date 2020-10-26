package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.dao.InventoryDAO;
import com.dbx.air.mvc.rest.dao.InventoryDAOInterface;
import com.dbx.air.mvc.rest.dao.UserDAO;
import com.dbx.air.mvc.rest.dao.UserDAOInterface;
import com.dbx.air.mvc.rest.entity.User;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryServiceTest {

    @Tested(fullyInitialized = true)
    private InventoryServiceInterface inventoryService;

    @Injectable
    private InventoryDAOInterface inventoryDAO;

    @Before
    public void setUp() throws Exception {
        inventoryDAO = new InventoryDAO();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInventory() {
        new Expectations() {{
            try {
                inventoryDAO.getInventories(new HashMap<String, List<String>>());
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = new User();
        }};
    }

    @Test
    public void deleteInventory() {
        new Expectations() {{
            try {
                inventoryDAO.deleteInventory(anyInt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = new User();
        }};
    }
}