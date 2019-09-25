package com.stack.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.stack.dto.StockDto;
import com.stack.dto.StockResponseDto;
import com.stack.entity.Stock;
import com.stack.service.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StackControllerTest {

	@Mock
	StockServiceImpl stockService;

	@InjectMocks
	StackController stockController;

	@Test
	public void testStockList() {
		List<Stock> list = new ArrayList<>();
		Stock stock1 = new Stock();
		stock1.setStockId(1);
		stock1.setStockName("Reliance");
		stock1.setUnitPrice(500);
		Stock stock2 = new Stock();
		stock2.setStockId(2);
		stock2.setStockName("ONGC");
		stock2.setUnitPrice(200);
		list.add(stock1);
		list.add(stock2);
		StockDto stockDto = new StockDto();
		BeanUtils.copyProperties(stock1, stockDto);
		List<StockDto> stockDtoList = new ArrayList<>();
		stockDtoList.add(stockDto);
		StockResponseDto stockRes = new StockResponseDto();
		stockRes.setData(stockDtoList);
		stockRes.setStatusCode(200);
		Mockito.when(stockService.getStockList()).thenReturn(stockRes);
		ResponseEntity<StockResponseDto> object = stockController.stockList();
		assertEquals(object.getBody().getStatusCode(), stockRes.getStatusCode());
	}

	

}
