package com.edward.dataproducer.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edward.dataproducer.service.PriceDataProducer;
import com.edward.dataproducer.service.PriceDataProducerFeign;
import com.edward.dataproducer.service.dto.SecurityPriceHistoryDTO;

import io.reactivex.Flowable;

@Service
public class PriceDataProducerImpl implements PriceDataProducer {

	private final int INTERNAL_SECONDS = 10;// generate data every 10 sec
	//@Autowired
	//private RestTemplateBuilder builder;
	
	private final RestTemplate restTemplate;
	
	@Autowired
	private PriceDataProducerFeign priceDataProducerFeign;

	public PriceDataProducerImpl(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@Override
	public void produceData() {
		Flowable.interval(1, INTERNAL_SECONDS, TimeUnit.SECONDS)
		//.take(5)//only emit 5 elements
		.blockingSubscribe(integer -> {
			System.out.println(integer);
			postDataToConsumerFeign();
			});
	}
	@Override
	public void postDataToConsumerFeign() {
		
		BigDecimal executionPrice = new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2);
		String securityNumber ="AAPL";
		SecurityPriceHistoryDTO securityPriceHistoryDTO = new SecurityPriceHistoryDTO(securityNumber, LocalDateTime.now(),executionPrice);
		priceDataProducerFeign.create(securityPriceHistoryDTO);
	}
	
	@Override
	public void postDataToConsumer() {
		
		BigDecimal executionPrice = new BigDecimal(BigInteger.valueOf(new Random().nextInt(10001)), 2);
		String securityNumber ="AAPL";
		SecurityPriceHistoryDTO securityPriceHistoryDTO = new SecurityPriceHistoryDTO(securityNumber, LocalDateTime.now(),executionPrice);
		String resourceUrl = "http://localhost:8080/securityPriceHistory/create";
		HttpEntity<SecurityPriceHistoryDTO> request = new HttpEntity<>(securityPriceHistoryDTO);
		SecurityPriceHistoryDTO securityPriceHistoryDTORes = restTemplate.postForObject(resourceUrl, request, SecurityPriceHistoryDTO.class);
	}



}
