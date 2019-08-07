package com.bbg.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbg.order.pojo.Orders;
import com.bbg.order.service.OrderService;
import com.bbg.service.OrdersService;
@RestController
public class OrdersController implements OrderService{

    @Autowired
    private OrdersService OrdersService;
    
    @Override
    public void addOrder(@RequestBody Orders orders) {
        // TODO Auto-generated method stub
        this.OrdersService.addOrders(orders);
    }
    
}
