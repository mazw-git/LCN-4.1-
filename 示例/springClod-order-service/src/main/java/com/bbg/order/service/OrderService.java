package com.bbg.order.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbg.order.pojo.Orders;

public interface OrderService {
    @RequestMapping(value="/addOrder",method=RequestMethod.POST)
    void addOrder(@RequestBody Orders orders);
}
