package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;

@RestController
@SpringCloudApplication
@EnableFeignClients
@EnableEurekaClient
public class DemoApplication {

	@Autowired
	OrderService orderService;

	@GetMapping("/order/{osn}")
	public String getOrderInfo(@PathVariable("osn") String orderSn) {
		return orderService.queryOrderInfo(orderSn);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
