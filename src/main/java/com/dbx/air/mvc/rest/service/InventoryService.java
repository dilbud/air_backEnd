package com.dbx.air.mvc.rest.service;

import com.dbx.air.mvc.rest.dao.InventoryDAOInterface;
import com.dbx.air.mvc.rest.entity.Invetory;
import com.dbx.air.mvc.rest.entity.Page;
import com.dbx.air.mvc.rest.entity.SuccessMsg;
import com.dbx.air.mvc.rest.entity.User;
import com.dbx.air.mvc.rest.exception.InventoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService implements InventoryServiceInterface{
    private final InventoryDAOInterface inventoryDAO;

    @Autowired
    public InventoryService(InventoryDAOInterface inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public SuccessMsg<List<Invetory>> getInventory(Map<String, String> allMap) throws Exception{

        HashMap <String, List<String>> daoMap = new HashMap<>();
        HashMap <String, Integer> pageMap = new HashMap<>();

        daoMap.put("brandCtrl", Arrays.asList(allMap.get("brandCtrl").split(",")));
        daoMap.put("typeCtrl", Arrays.asList(allMap.get("typeCtrl").split(",")));
        daoMap.put("textCtrl", Arrays.asList(allMap.get("textCtrl").split(",")));

        pageMap.put("length", Integer.valueOf(allMap.get("length")));
        pageMap.put("pageIndex", Integer.valueOf(allMap.get("pageIndex")));
        pageMap.put("pageSize", Integer.valueOf(allMap.get("pageSize")));
        pageMap.put("previousPageIndex", Integer.valueOf(allMap.get("previousPageIndex")));

        List<Invetory> filteredArray = inventoryDAO.getInventories(daoMap);
        if (filteredArray.size() == 0) {
            throw new InventoryNotFoundException();
        }
        int length = filteredArray.size();
        pageMap.replace("length",length);

        filteredArray = filteredArray.subList(pageMap.get("pageIndex") * pageMap.get("pageSize"), Math.min((pageMap.get("pageIndex")+1) * pageMap.get("pageSize"), length));
        SuccessMsg msg = new SuccessMsg<List<Invetory>>();
        msg.setStatus("200");
        msg.setMessage("Inventory Data");
        msg.setTimeStamp(LocalDateTime.now().toString());
        msg.setPage(new Page(pageMap.get("previousPageIndex"),pageMap.get("pageIndex"),pageMap.get("pageSize"),pageMap.get("length")));
        msg.setData(filteredArray);
        return msg;
    }

    @Override
    public SuccessMsg<Integer> deleteInventory(Integer id) throws Exception {

        SuccessMsg<Integer> msg  = new SuccessMsg<Integer>();
        msg.setTimeStamp(LocalDateTime.now().toString());

        switch (inventoryDAO.deleteInventory(id)) {
            case DELETED:
            {
                msg.setMessage("Item deleted");
                msg.setStatus("200");
                return msg;
            }
            case NOTFOUND:
            {
                throw new InventoryNotFoundException();
            }
            default:
            {
                throw new Exception();
            }
        }
    }

}
