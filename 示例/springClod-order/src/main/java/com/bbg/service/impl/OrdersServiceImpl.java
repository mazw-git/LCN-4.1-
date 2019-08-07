package com.bbg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbg.mapper.OrderMapper;
import com.bbg.order.pojo.Orders;
import com.bbg.service.OrdersService;
import com.bbg.tx.annotation.TxTransaction;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderMapper OrderMapper;

    @Override
    @Transactional
    @TxTransaction
    public void addOrders(Orders orders) {
        // TODO Auto-generated method stub
        this.OrderMapper.insertOrder(orders);
    }
    

}
