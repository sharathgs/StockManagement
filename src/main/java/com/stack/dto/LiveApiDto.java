package com.stack.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiveApiDto {

	@JsonProperty("Global Quote")
	private LivePriceDto globalQuote;
}
