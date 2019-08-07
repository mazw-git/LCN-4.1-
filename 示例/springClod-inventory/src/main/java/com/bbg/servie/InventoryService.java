package com.bbg.servie;

import com.bbg.inventory.pojo.Inventory;

public interface InventoryService {
    void updateInventory(Inventory inventory);
    
    void addItem(Inventory inventory);

    void addItemErr(Inventory inventory);
    
}
