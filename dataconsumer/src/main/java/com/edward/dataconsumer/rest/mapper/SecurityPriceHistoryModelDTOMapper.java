package com.edward.dataconsumer.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.edward.dataconsumer.rest.model.SecurityPriceHistoryModel;
import com.edward.dataconsumer.service.dto.SecurityPriceHistoryDTO;

@Mapper
public interface SecurityPriceHistoryModelDTOMapper {

	SecurityPriceHistoryDTO modelToDTO(SecurityPriceHistoryModel securityPriceHistoryModel);
	
	SecurityPriceHistoryModel dtoToModel(SecurityPriceHistoryDTO securityPriceHistoryDTO);
	
	List<SecurityPriceHistoryModel> dtoToModelList(List<SecurityPriceHistoryDTO> securityPriceHistoryDTOs);
}
