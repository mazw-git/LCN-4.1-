package com.bbg.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.bbg.order.service.OrderService;

@FeignClient("springColud-order")
public interface Portal_Orders_Service extends OrderService{

}
