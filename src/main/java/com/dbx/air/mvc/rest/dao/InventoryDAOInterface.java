package com.dbx.air.mvc.rest.dao;

import com.dbx.air.mvc.rest.entity.InventoryState;
import com.dbx.air.mvc.rest.entity.Invetory;

import java.util.HashMap;
import java.util.List;

public interface InventoryDAOInterface {
    List<Invetory> getInventories(HashMap<String, List<String>> allMap) throws Exception;

    InventoryState deleteInventory(Integer id) throws Exception;

    InventoryState updateInventory(Integer id, Invetory item) throws Exception;

    InventoryState addInventory(Invetory item) throws Exception;
}
