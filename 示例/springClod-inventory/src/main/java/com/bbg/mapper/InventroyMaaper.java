package com.bbg.mapper;

import com.bbg.inventory.pojo.Inventory;

public interface InventroyMaaper {
    void updataInventory(Inventory inventory);
    
    void addItem(Inventory inventory);
    
    void addItemErr(Inventory inventory);
}
