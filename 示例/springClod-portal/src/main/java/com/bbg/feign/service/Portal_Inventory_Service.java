package com.bbg.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.bbg.inventory.service.InventroyService;

@FeignClient("springColud-inventory")
public interface Portal_Inventory_Service extends InventroyService {

}
