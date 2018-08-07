package com.edward.dataconsumer.service;

import java.math.BigDecimal;
import java.util.List;

import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;

public interface SecurityPriceHistoryService {
	
	SecurityPriceHistoryDTO saveSecurityPriceHistory(SecurityPriceHistoryDTO securityPriceHistoryDTO);
	
	BigDecimal calculateAveragePriceForLastRecord(String securityNumber,int lastRecordCount);
	
	BigDecimal calculateAveragePrice(List<BigDecimal> priceList);

}
