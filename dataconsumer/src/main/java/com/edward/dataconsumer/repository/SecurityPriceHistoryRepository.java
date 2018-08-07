package com.edward.dataconsumer.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.edward.dataconsumer.repository.entity.SecurityPriceHistory;

public interface SecurityPriceHistoryRepository extends MongoRepository<SecurityPriceHistory, String> {

	Page<SecurityPriceHistory> findPageBySecurityNumber(String securityNumber, Pageable pageable);
	
	@Query("{ 'securityNumber' : ?0 }")
	List<SecurityPriceHistory> findAllBySecurityNumber(String securityNumber);
}
