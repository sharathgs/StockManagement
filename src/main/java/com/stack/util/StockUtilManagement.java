package com.stack.util;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.stack.dto.LiveApiDto;
import com.stack.dto.StockRestDto;

@Configuration
public class StockUtilManagement {

	public Double stockPrice(int quantity, Double price)
	{
		Double stockTotalPrice = quantity * price;
		return stockTotalPrice;
	}
	
	public StockRestDto getCurrentStockPrice(String url)
	{
		StockRestDto stockRestDto = new StockRestDto();
		RestTemplate restTemplate = new RestTemplate();
		LiveApiDto stock = restTemplate.exchange(url, HttpMethod.GET,null,LiveApiDto.class).getBody();
		
		stockRestDto.setUnitPrice(Double.valueOf(stock.getGlobalQuote().getPrice().toString()));
		return stockRestDto;
	}
	
}
