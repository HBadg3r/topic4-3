package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrderDataService;
import com.gcu.entity.OrderEntity;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface{
	
	@Autowired
	private OrderDataService service;
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
		
	}

	@Override
	public List<OrderModel> getOrders() {
		
		// Get all the Entity Orders
		List<OrderEntity> ordersEntity = service.findAll();
		
		// Iterate over the Entity Orders and create a list of Domain Orders
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		
		for (OrderEntity entity : ordersEntity) {
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		// Return list of Domain Orders
		return ordersDomain;
	}

	@Override
	public void init() {
		System.out.println("OderBusinessService init");
		
	}

	@Override
	public void destroy() {
		System.out.println("OderBusinessService destroy");
		
	}
}
