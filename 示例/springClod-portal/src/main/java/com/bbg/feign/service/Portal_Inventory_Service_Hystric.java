package com.bbg.feign.service;

import com.bbg.inventory.pojo.Inventory;

public class Portal_Inventory_Service_Hystric {

    public void updataItemNum(Inventory inventory) {
        // TODO Auto-generated method stub
        System.out.println("进入断路器-list。。。");
        throw new RuntimeException("list 保存失败.");
    }

}
