package org.ptrading.datafeed;

import org.ptrading.datafeed.service.MarketDataFeedListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PtradingDatafeedHandlerApplication {

	@Autowired
	private MarketDataFeedListener marketDataFeedListener;
	
	public static void main(String[] args) {
		SpringApplication.run(PtradingDatafeedHandlerApplication.class, args);
		
	}

}
