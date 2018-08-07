package com.edward.dataconsumer.rest.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edward.dataconsumer.rest.mapper.SecurityPriceHistoryModelDTOMapper;
import com.edward.dataconsumer.rest.model.SecurityPriceHistoryModel;
import com.edward.dataconsumer.service.SecurityPriceHistoryService;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;

@RestController("/securityPriceHistory")
public class SecurityPriceHistoryController {
	
	@Autowired
	private SecurityPriceHistoryService securityPriceHistoryService;
	@Autowired
	private SecurityPriceHistoryModelDTOMapper mapper;

	@RequestMapping(name="/create",method=RequestMethod.POST)
    public SecurityPriceHistoryModel create(@RequestBody SecurityPriceHistoryModel securityPriceHistoryModel) {
		SecurityPriceHistoryDTO securityPriceHistoryDTO = securityPriceHistoryService.saveSecurityPriceHistory(mapper.modelToDTO(securityPriceHistoryModel));
		return mapper.dtoToModel(securityPriceHistoryDTO);
    }
	
	@RequestMapping(name="/calculateAverage",method=RequestMethod.GET)
	public BigDecimal calculateAverage(@RequestParam(value="securityNumber") String securityNumber,@RequestParam(value="lastRecordCount") int lastRecordCount) {
		return securityPriceHistoryService.calculateAveragePriceForLastRecord(securityNumber, lastRecordCount);
	}
	
}
