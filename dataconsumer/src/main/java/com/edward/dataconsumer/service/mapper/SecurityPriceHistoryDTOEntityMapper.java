package com.edward.dataconsumer.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.edward.dataconsumer.repository.entity.SecurityPriceHistory;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SecurityPriceHistoryDTOEntityMapper {

	@Mapping(source = "securityNumber", target = "securityNumber")
	SecurityPriceHistoryDTO entityToDTO(SecurityPriceHistory securityPriceHistory);
	
	SecurityPriceHistory dtoToEntity(SecurityPriceHistoryDTO securityPriceHistoryDTO);
	
}
