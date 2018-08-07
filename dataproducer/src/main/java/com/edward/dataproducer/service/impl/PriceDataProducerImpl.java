package com.edward.dataproducer.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.edward.dataproducer.service.PriceDataProducer;

import io.reactivex.Flowable;

@Service
public class PriceDataProducerImpl implements PriceDataProducer {

	private final int INTERNAL_SECONDS = 5;// generate data every 10 sec
	@Override
	public void produceData() {
		// TODO Auto-generated method stub
		Flowable.interval(0, INTERNAL_SECONDS, TimeUnit.SECONDS)
		.take(5)//only emit 5 elements
		.blockingSubscribe(integer -> {System.out.println(integer);});
	}

}
