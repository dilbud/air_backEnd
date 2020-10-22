package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.entity.Invetory;
import com.dbx.air.mvc.rest.entity.SuccessMsg;

import java.util.List;
import java.util.Map;

public interface InventoryServiceInterface {
    SuccessMsg<List<Invetory>> getInventory(Map<String, String> allMap) throws Exception;
    SuccessMsg<List<Invetory>> deleteInventory(Integer id, Map<String, String> allMap) throws Exception;
}
