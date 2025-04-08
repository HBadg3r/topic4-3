package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.business.*;

@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
}
