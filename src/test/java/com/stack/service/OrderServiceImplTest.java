package com.stack.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.stack.dto.OrderDto;
import com.stack.dto.OrderResDto;
import com.stack.entity.Stock;
import com.stack.entity.User;
import com.stack.respository.OrderRepository;
import com.stack.respository.StockRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	
	@Mock
	OrderRepository orderRepository;
	
	
	@Mock
	StockRepository stockRepository;
	
	@InjectMocks
	
	OrderServiceImpl orderService;
	//@Test
	/*public void testGetAll() {
		User user = new User();
		user.setUserId(1);
		Orders order = new Orders();
		order.setOrderId(1);
		order.setOrderStatus("SUCCESS");order.setUserId(user.getUserId());
		order.setQuantity(20);
		order.setStockId(1);
		Stock stock= new Stock();
		stock.setStockName("Reliance");
		List<Orders> listOrder = new ArrayList<>();
		listOrder.add(order);
		Mockito.when(orderRepository.findAllByuserId(Mockito.anyInt())).thenReturn(listOrder);
		Mockito.when(stockRepository.findById()).thenReturn(stock);
		List<OrderDto> orderDto = new ArrayList<>();
		OrderDto orderDto1= new OrderDto();
		BeanUtils.copyProperties(order, orderDto1);
		orderDto.add(orderDto1);
		OrderResDto orderRes = new OrderResDto();
		orderRes.setData(orderDto);
		OrderResDto orderResDto = orderService.getAll(1);
		assertEquals(orderResDto.getData().size(), 1);
	}*/

}
