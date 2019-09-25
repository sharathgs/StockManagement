package com.stack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stack.dto.OrderResDto;
import com.stack.dto.StockPriceDto;
import com.stack.dto.StockResponseDto;
import com.stack.service.OrderService;
import com.stack.service.StockService;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
@Slf4j
public class StackController {


	@Autowired
	StockService stockService;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/stocks")
	public ResponseEntity<StockResponseDto> stockList(){
			log.info("stocklist controller method");
		return new ResponseEntity<>(stockService.getStockList(), HttpStatus.OK);
	}
	
	@GetMapping("/api/users/{userId}/orders")
	public ResponseEntity<OrderResDto> getAll(@PathVariable Integer userId){
		
		return new ResponseEntity<>(orderService.getAll(userId),HttpStatus.OK);
	}
	
	@GetMapping("/api/stocks/{stockId}/price")
	public ResponseEntity<StockPriceDto> getStockPrice(@PathVariable Integer stockId, @RequestParam(value = "quantity") Integer quantity)
	{
		log.info("event for the controller per stock price called");
		return new ResponseEntity<>(stockService.stockPrice(stockId, quantity),HttpStatus.OK);
	}
	
}
