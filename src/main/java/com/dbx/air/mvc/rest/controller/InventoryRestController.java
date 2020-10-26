package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.entity.Invetory;
import com.dbx.air.mvc.rest.entity.SuccessMsg;
import com.dbx.air.mvc.rest.exception.BadRequestException;
import com.dbx.air.mvc.rest.service.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * dashboard request handler
 */
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/dashboard")
public class InventoryRestController {

    private  InventoryServiceInterface inventoryService;

    @Autowired
    public InventoryRestController(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }

    /**
     * @param allMap
     * @param userId
     * @return SuccessMsg JSON object
     * @throws Exception
     */
    @GetMapping("/inventories")
    public SuccessMsg<List<Invetory>> getInventories(
            @RequestParam() Map<String, String> allMap ,
            @CookieValue(value = "userId", defaultValue = "0") int userId) throws Exception {

        SuccessMsg<List<Invetory>> msg ;
        if(allMap.keySet().toArray().length == 7) {
            msg = inventoryService.getInventory(allMap);
        } else {
            throw new BadRequestException();
        }

        return msg ;
    }

    /**
     * @param id
     * @param allMap
     * @param userId
     * @return SuccessMsg JSON object
     * @throws Exception
     */
    @DeleteMapping("/inventories/{id}")
    public SuccessMsg<List<Invetory>> deleteInventories(
            @PathVariable Integer id,
            @RequestParam() Map<String, String> allMap ,
            @CookieValue(value = "userId", defaultValue = "0") int userId) throws Exception {

        SuccessMsg<List<Invetory>> msg;
        if(allMap.keySet().toArray().length == 7) {
            msg = inventoryService.deleteInventory(id,allMap);
        } else {
            throw new BadRequestException();
        }

        return msg;
    }
}
