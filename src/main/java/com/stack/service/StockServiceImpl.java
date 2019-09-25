package com.stack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stack.dto.StockDto;
import com.stack.dto.StockPriceDto;
import com.stack.dto.StockResponseDto;
import com.stack.dto.StockRestDto;
import com.stack.entity.Stock;
import com.stack.respository.StockRepository;
import com.stack.util.StockUtilManagement;
import com.stack.util.StockUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;

	@Autowired
	StockUtilManagement stockManagement;
	
	@Value("${services.api.url}")
	private String stockUrl;

	@Override
	public StockResponseDto getStockList() {

		log.info("stocklist service method");
		List<Stock> stockList = stockRepository.findAll();
		List<StockDto> stockDtoList = new ArrayList<>();

		StockResponseDto stockResponseDto = new StockResponseDto();

		stockList.forEach(stock -> {
			StockDto stockDto = new StockDto();
			BeanUtils.copyProperties(stock, stockDto);
			stockDtoList.add(stockDto);
		});

		stockResponseDto.setData(stockDtoList);
		return stockResponseDto;
	}

	public StockPriceDto stockPrice(Integer stockId, Integer quantity) {
		StockPriceDto stockPrice = new StockPriceDto();
		Stock stockData = stockRepository.findById(stockId).get();
		String stockName = stockData.getStockName();
		Double stockUnitPrice = stockData.getUnitPrice();

		StockRestDto stockRest = stockManagement.getCurrentStockPrice(stockUrl+stockName+"&apikey=KFJWFM57YUCK6IWR");
		
		stockPrice.setMessage(StockUtils.STOCK_PRICE);
		stockPrice.setUnitPrice(stockUnitPrice);
		stockPrice.setTotalPrice(stockManagement.stockPrice(quantity, stockUnitPrice));
		stockPrice.setCurrentUnitPrice(stockRest.getUnitPrice());
		stockPrice.setCurrentTotalPrice(stockManagement.stockPrice(quantity, stockRest.getUnitPrice()));

		return stockPrice;
	}

}
