package com.bbg.inventory.pojo;

import java.io.Serializable;

public class Inventory implements Serializable{
    private Integer inventoryid;
    private Integer itemid;
    private Integer itemnum;
    public Integer getInventoryid() {
        return inventoryid;
    }
    public void setInventoryid(Integer inventoryid) {
        this.inventoryid = inventoryid;
    }
    public Integer getItemid() {
        return itemid;
    }
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
    public Integer getItemnum() {
        return itemnum;
    }
    public void setItemnum(Integer itemnum) {
        this.itemnum = itemnum;
    }
    
    
}
