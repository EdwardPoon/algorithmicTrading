package com.edward.dataproducer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edward.dataproducer.service.dto.SecurityPriceHistoryDTO;

@FeignClient("dataconsumer")
public interface PriceDataProducerFeign {
	
	@RequestMapping("/securityPriceHistory/create")
	public SecurityPriceHistoryDTO create(@RequestBody SecurityPriceHistoryDTO securityPriceHistoryDTO);

	
}
