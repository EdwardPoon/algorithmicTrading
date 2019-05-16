package org.ptrading.datafeed.service;

import org.ptrading.datafeed.model.EquityDataFeed;

public interface SecurityDataFeedService {
	
	void saveFeed(EquityDataFeed equityDataFeed);

}
