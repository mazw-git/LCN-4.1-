package com.bbg.servie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbg.inventory.pojo.Inventory;
import com.bbg.mapper.InventroyMaaper;
import com.bbg.servie.InventoryService;
import com.bbg.tx.annotation.TxTransaction;

@Service
public class InventoryServiceImpl implements InventoryService {
    
    @Autowired
    private InventroyMaaper inventroyMaaper;
    
    @Override
    @Transactional
    @TxTransaction
    public void updateInventory(Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventroyMaaper.updataInventory(inventory);
    }

    @Override
    @Transactional
    @TxTransaction
    public void addItem(Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventroyMaaper.addItem(inventory);
    }

    @Override
    @Transactional
    @TxTransaction
    public void addItemErr(Inventory inventory) {
        // TODO Auto-generated method stub
        this.inventroyMaaper.addItemErr(inventory);
    }
}
