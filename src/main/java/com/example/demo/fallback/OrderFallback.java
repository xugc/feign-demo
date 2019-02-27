package com.example.demo.fallback;

import org.springframework.stereotype.Component;

import com.example.demo.service.OrderService;

@Component
public class OrderFallback implements OrderService {

	@Override
	public String queryOrderInfo(String orderSn) {
		return "获取订单信息超时" + orderSn;
	}

}
