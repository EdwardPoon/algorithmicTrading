package org.ptrading.datatransformer.service;

import org.springframework.stereotype.Service;

import net.openhft.chronicle.bytes.MethodReader;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueue;
import net.openhft.chronicle.queue.impl.single.SingleChronicleQueueBuilder;

@Service
public class DataTransformService {
	
	private final String EQUITY_MARKET_DATA_QUEUE = "org.ptrading.marketdata.equity";
	
	public void transformDataFeed()  {
		
		try (SingleChronicleQueue queue = SingleChronicleQueueBuilder.binary(EQUITY_MARKET_DATA_QUEUE).build()){
	        
	        SecurityDataFeedService securityDataFeedService = System.out::println;
	        MethodReader methodReader = queue.createTailer().methodReader(securityDataFeedService);
	
	        while (true) {
	            if (!methodReader.readOne())
	                Thread.sleep(1000);
	        }
		}catch(InterruptedException e) {
			
		}
	}

}
