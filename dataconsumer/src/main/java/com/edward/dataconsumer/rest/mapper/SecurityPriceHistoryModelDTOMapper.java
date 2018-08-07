package com.edward.dataconsumer.rest.mapper;

import org.mapstruct.Mapper;

import com.edward.dataconsumer.rest.model.SecurityPriceHistoryModel;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;

@Mapper
public interface SecurityPriceHistoryModelDTOMapper {

	SecurityPriceHistoryDTO modelToDTO(SecurityPriceHistoryModel securityPriceHistoryModel);
	
	SecurityPriceHistoryModel dtoToModel(SecurityPriceHistoryDTO securityPriceHistoryDTO);
}
