package com.bbg.web.contorller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbg.inventory.pojo.Inventory;
import com.bbg.inventory.service.InventroyService;
import com.bbg.servie.InventoryService;

@RestController
public class InventoryContorller implements InventroyService{

    @Autowired
    private InventoryService inventoryService;
    
    @Override
    public void updataItemNum(@RequestBody Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventoryService.updateInventory(inventory);
    }

    @Override
    public void addItem(@RequestBody Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventoryService.addItem(inventory);
    }
    
    @Override
    public void addItemRandomErr(@RequestBody Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventoryService.addItem(inventory);
        Random random = new Random();
        if(random.nextInt()<3){
            int v = 1/0;
        }
    }
    
    @Override
    public void addItemErr(@RequestBody Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventoryService.addItemErr(inventory);
    }
}
