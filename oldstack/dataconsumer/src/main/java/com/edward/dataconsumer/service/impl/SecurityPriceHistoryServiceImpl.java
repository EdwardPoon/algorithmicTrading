package com.edward.dataconsumer.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.edward.dataconsumer.repository.SecurityPriceHistoryRepository;
import com.edward.dataconsumer.repository.entity.SecurityPriceHistory;
import com.edward.dataconsumer.service.SecurityPriceHistoryService;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;
import com.edward.dataconsumer.service.mapper.SecurityPriceHistoryDTOEntityMapper;

@Service
public class SecurityPriceHistoryServiceImpl implements SecurityPriceHistoryService {

	@Autowired
	private SecurityPriceHistoryRepository repository;
	@Autowired
	private SecurityPriceHistoryDTOEntityMapper mapper;
	
	@Override
	public SecurityPriceHistoryDTO saveSecurityPriceHistory(SecurityPriceHistoryDTO securityPriceHistoryDTO) {
		SecurityPriceHistory securityPriceHistory = repository.save(mapper.dtoToEntity(securityPriceHistoryDTO));
		SecurityPriceHistoryDTO ret = mapper.entityToDTO(securityPriceHistory);
		System.out.println("save successfully:"+ret.toString());
		return ret;
	}

	@Override
	public BigDecimal calculateAveragePriceForLastRecord(String securityNumber,int lastRecordCount) {
		PageRequest pageRequest = PageRequest.of(0, lastRecordCount,
                new Sort(Direction.DESC, "executionTime"));
		Page<SecurityPriceHistory> page = repository.findPageBySecurityNumber(securityNumber,pageRequest);
		List<BigDecimal> priceList = new ArrayList<BigDecimal>();
		for (SecurityPriceHistory securityPriceHistory :page.getContent()) {
			priceList.add(securityPriceHistory.getExecutionPrice());
		}
		return calculateAveragePrice(priceList);
	}

	@Override
	public BigDecimal calculateAveragePrice(List<BigDecimal> priceList) {
		BigDecimal sumPrice = BigDecimal.ZERO;
		for (BigDecimal price : priceList) {
			sumPrice = sumPrice.add(price);
		}
		return sumPrice.divide(BigDecimal.valueOf(priceList.size()), 2, RoundingMode.HALF_UP);
	}

	@Override
	public List<SecurityPriceHistoryDTO> findAll(String securityNumber) {
		List<SecurityPriceHistory> list = repository.findAllBySecurityNumber(securityNumber);
		List<SecurityPriceHistoryDTO> retList = new ArrayList<SecurityPriceHistoryDTO>();
		for (SecurityPriceHistory securityPriceHistory : list) {
			retList.add( mapper.entityToDTO(securityPriceHistory));
		}
		return retList;
	}

}
