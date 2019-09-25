package com.stack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.dto.OrderDto;
import com.stack.dto.OrderResDto;
import com.stack.entity.Orders;
import com.stack.entity.Stock;
import com.stack.respository.OrderRepository;
import com.stack.respository.StockRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public OrderResDto getAll(Integer userId) {
		List<Orders> orderList = orderRepository.findAllByuserId(userId);
		List<OrderDto> orderDtoList = new ArrayList<>();
		OrderResDto orderResDto = new OrderResDto();
		for(Orders list  :orderList) {
			Stock stock = stockRepository.findById(list.getStockId()).get();
			OrderDto order = new OrderDto();
			order.setOrderedDate(list.getOrderDate());
			order.setQuantity(list.getQuantity());
			order.setStatus(list.getOrderStatus());
			order.setStockName(stock.getStockName());
			order.setTotalPrice(list.getTotalPrice());
			order.setUnitPrice(list.getUnitPrice());
			order.setOrderId(list.getOrderId());
			orderDtoList.add(order);
		}
		orderResDto.setData(orderDtoList);
		
		return orderResDto;
	}

}
