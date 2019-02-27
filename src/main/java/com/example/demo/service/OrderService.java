package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.fallback.OrderFallback;

@FeignClient(value = "order-service", fallback = OrderFallback.class)
public interface OrderService {
	@GetMapping("/query/{osn}")
	String queryOrderInfo(@PathVariable("osn") String orderSn);
}
