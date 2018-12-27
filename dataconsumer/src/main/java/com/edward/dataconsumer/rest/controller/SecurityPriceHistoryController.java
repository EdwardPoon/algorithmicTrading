package com.edward.dataconsumer.rest.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edward.dataconsumer.rest.mapper.SecurityPriceHistoryModelDTOMapper;
import com.edward.dataconsumer.rest.model.AveragePriceModel;
import com.edward.dataconsumer.rest.model.SecurityPriceHistoryModel;
import com.edward.dataconsumer.service.SecurityPriceHistoryService;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;
import com.edward.dataconsumer.utils.VerifyUtil;

@RestController
@RequestMapping("/securityPriceHistory")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)// use @CrossOrigin for convenient, should introduce nginx
public class SecurityPriceHistoryController {
	
	@Autowired
	private SecurityPriceHistoryService securityPriceHistoryService;
	@Autowired
	private SecurityPriceHistoryModelDTOMapper mapper;

	@RequestMapping(value="/create",method=RequestMethod.POST)
    public SecurityPriceHistoryModel create(@RequestBody SecurityPriceHistoryModel securityPriceHistoryModel) {
		SecurityPriceHistoryDTO securityPriceHistoryDTO = securityPriceHistoryService.saveSecurityPriceHistory(mapper.modelToDTO(securityPriceHistoryModel));
		return mapper.dtoToModel(securityPriceHistoryDTO);
    }
	
	@RequestMapping(value="/calculateAverage",method=RequestMethod.GET)
	public AveragePriceModel calculateAverage(@RequestParam(value="securityNumber") String securityNumber,@RequestParam(value="lastRecordCount") String lastRecordCount) {
		AveragePriceModel averagePriceModel = null;
		if (VerifyUtil.isInteger(lastRecordCount)) {
			BigDecimal averagePrice = securityPriceHistoryService.calculateAveragePriceForLastRecord(securityNumber, Integer.valueOf(lastRecordCount));
			averagePriceModel = new AveragePriceModel(averagePrice,"success","");
		}else {
			averagePriceModel = new AveragePriceModel(BigDecimal.ZERO,"","please input integer value");
		}
		return averagePriceModel;
	}
	
	@RequestMapping(value="/findAll",method=RequestMethod.GET)
	public List<SecurityPriceHistoryModel> findAll(@RequestParam(value="securityNumber") String securityNumber) {
		return mapper.dtoToModelList(securityPriceHistoryService.findAll(securityNumber));
	}

	
	
}
