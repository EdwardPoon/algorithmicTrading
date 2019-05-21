package org.ptrading.datafeed;

import org.ptrading.datafeed.service.MarketDataFeedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PtradingDatafeedHandlerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PtradingDatafeedHandlerApplication.class, args);
		MarketDataFeedListener marketDataFeedListener = ctx.getBean(MarketDataFeedListener.class);
		marketDataFeedListener.listenData();
		
	}

}
