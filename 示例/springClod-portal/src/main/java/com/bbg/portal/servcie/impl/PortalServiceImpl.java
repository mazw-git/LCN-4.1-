package com.bbg.portal.servcie.impl;

import com.bbg.feign.service.Portal_Inventory_Service;
import com.bbg.feign.service.Portal_Orders_Service;
import com.bbg.inventory.pojo.Inventory;
import com.bbg.order.pojo.Orders;
import com.bbg.portal.servcie.PortalService;
import com.bbg.tx.annotation.TxTransaction;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PortalServiceImpl implements PortalService {

    @Autowired
    private Portal_Inventory_Service inventorService;

    @Autowired
    private Portal_Orders_Service ordersServcie;

    @Override
    // @HystrixCommand(fallbackMethod = "addOrderFallback")
    @TxTransaction(isStart = true)
    public void testRandomErr() {
        // TODO Auto-generated method stub
        Orders orders = new Orders();
        orders.setItemid(100);
        orders.setPrice(2000);
        Inventory inventory = new Inventory();
        inventory.setItemid(100);
        inventory.setItemnum(9);
        ordersServcie.addOrder(orders);
        inventorService.addItem(inventory);
        Random random = new Random();
        if (random.nextInt() < 5) {
            int v = 1 / 0;
        }
    }

    @TxTransaction(isStart = true)
    public void testRepeatCall() {
        // TODO Auto-generated method stub
        Orders orders = new Orders();
        orders.setPrice(2000);
        Inventory inventory = new Inventory();
        inventory.setItemnum(88);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            orders.setItemid(i);
            inventory.setItemid(i);
            ordersServcie.addOrder(orders);
            inventorService.addItem(inventory);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("当前程序耗时：" + (endTime - startTime) + "ms");
        
        /* 预期结果：所有事务正常提交
         * 执行结果：有时所有事务回滚，有时部分事务提交
         * 测试结果：事务管理失败
         * 
         * 引发原因：当程序运行时间超过TX-MANAGER配置文件的tm.compensate.maxWaitTime配置的值时，tx-client端会当作事务发起方
         * 已经挂掉，然后执行事务回滚
         * 
         * 通过加大设置的值，事务可以正常被管理
         * 
         * */

    }

    @TxTransaction(isStart = true)
    public void testLoopCall(int i) {
        // TODO Auto-generated method stub
        Orders orders = new Orders();
        orders.setPrice(2000);
        orders.setItemid(i);
        Inventory inventory = new Inventory();
        inventory.setItemnum(88);
        inventory.setItemid(i);
        ordersServcie.addOrder(orders);
        inventorService.addItemRandomErr(inventory);

    }

    @Override
    @HystrixCommand(fallbackMethod = "testHystrixBack")
    @TxTransaction(isStart = true)
    public void testHystrix() {
        // TODO Auto-generated method stub
        Orders orders = new Orders();
        orders.setItemid(100);
        orders.setPrice(2000);
        Inventory inventory = new Inventory();
        inventory.setItemid(100);
        inventory.setItemnum(9);
        ordersServcie.addOrder(orders);
        inventorService.addItemErr(inventory);
        
        
        /*
         * 预期结果：所有事务回滚
         * 执行结果：事务部分提交
         * 测试结果：事务管理失败
         * */
    }

    @Override
    public void pressureTest() {

    }

    public void testHystrixBack() {
        System.out.println("进入断路器-testHystrixBack......");
    }
}
