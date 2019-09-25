package com.stack.dto;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LivePriceDto {

	@JsonProperty("01. symbol")
	private String symbol;
	
	@JsonProperty("02. open")
	private String open;
	
	@JsonProperty("03. high")
	private String high;
	
	@JsonProperty("04. low")
	private String low;
	
	
	@JsonProperty("05. price")
	private String price;
	
	@JsonProperty("06. volume")
	private String volume;
	
	
	@JsonProperty("07. latest trading day")
	private String latestTrading;
	
	@JsonProperty("08. previous close")
	private String previousClose;
	
	@JsonProperty("09. change")
	private String change;
	
	@JsonProperty("10. change percent")
	private String changePercent;

}
