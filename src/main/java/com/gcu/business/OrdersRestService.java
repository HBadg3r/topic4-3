package com.gcu.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.*;

@RestController
@RequestMapping("/service")
public class OrdersRestService {

	@Autowired
	protected OrdersBusinessServiceInterface service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrdersRestService.class);

	@GetMapping(path="/getjson", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrderAsJson() {
		logger.trace("==========> In getOrdersAsJson() at" + "/getjson");
		List<OrderModel> orders = service.getOrders();

		if (orders != null) 
		{
			throw new RuntimeException("Something bad happened");
		}

		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml() {
		logger.trace("==========> In getOrdersAsXml() at" + "/getxml");
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
}
