package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.entity.Invetory;
import com.dbx.air.mvc.rest.entity.SuccessMsg;

import java.util.List;
import java.util.Map;

public interface InventoryServiceInterface {
    SuccessMsg<List<Invetory>> getInventory(Map<String, String> allMap) throws Exception;

    SuccessMsg<Integer> deleteInventory(Integer id) throws Exception;

    SuccessMsg<Integer> updateInventory(Integer id, Invetory item) throws Exception;

    SuccessMsg<Integer> addInventory(Invetory item) throws Exception;
}
