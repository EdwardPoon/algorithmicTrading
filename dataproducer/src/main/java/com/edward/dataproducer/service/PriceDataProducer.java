package com.edward.dataproducer.service;

public interface PriceDataProducer {

	public void produceData();
	
	public void postDataToConsumer();
	public void postDataToConsumerFeign();
}
