package org.ptrading.datafeed.service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.ptrading.datafeed.model.EquityDataFeed;
import org.springframework.stereotype.Service;

import io.reactivex.Flowable;
import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptAppender;

@Service
public class MarketDataFeedListener {

	private static int INTERVAL = 1000;
	private final String EQUITY_MARKET_DATA_QUEUE = "org.ptrading.marketdata.equity";
	
	// simulate market data feed
	public void listenData() {
		// trigger every 100 millisecond
		try (ChronicleQueue queue = ChronicleQueue.singleBuilder(EQUITY_MARKET_DATA_QUEUE).build()) {
			final ExcerptAppender appender = queue.acquireAppender();

			SecurityDataFeedService securityDataFeedService = appender.methodWriter(SecurityDataFeedService.class);
			
			Flowable.interval(0, INTERVAL, TimeUnit.MILLISECONDS)
					// .take(5)//only emit 5 elements
					.blockingSubscribe(integer -> {
						System.out.println(integer);
						EquityDataFeed feed = generateEquityDataFeed();
						System.out.println(feed);
						//securityDataFeedService.saveFeed(feed);
					});
		}
	}
	
	private EquityDataFeed generateEquityDataFeed() {
		
		BigDecimal basePrice = BigDecimal.valueOf(305);
		Random random = new Random();
		BigDecimal bidPrice = basePrice.subtract(BigDecimal.valueOf(random.nextInt(10)));
		BigDecimal askPrice = basePrice.add(BigDecimal.valueOf(random.nextInt(10)));
		Instant pricingTime = LocalDateTime.now().toInstant(ZoneOffset.UTC);
		
		return new EquityDataFeed("AAPL",LocalDate.now(),pricingTime,bidPrice,pricingTime,BigDecimal.valueOf(100),
				askPrice,pricingTime,BigDecimal.valueOf(100));
		
	}


}
