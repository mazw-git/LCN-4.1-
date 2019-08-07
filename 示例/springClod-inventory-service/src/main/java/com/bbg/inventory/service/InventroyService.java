package com.bbg.inventory.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbg.inventory.pojo.Inventory;

public interface InventroyService {
    
    @RequestMapping(value="/updataItemNum",method=RequestMethod.POST)
    void updataItemNum(@RequestBody Inventory inventory);
    
    
    @RequestMapping(value="/addItem",method=RequestMethod.POST)
    void addItem(@RequestBody Inventory inventory); 
    
    @RequestMapping(value="/addItemRandErr",method=RequestMethod.POST)
    void addItemRandomErr(@RequestBody Inventory inventory); 
    
    @RequestMapping(value="/addItemErr",method=RequestMethod.POST)
    void addItemErr(@RequestBody Inventory inventory); 
}
