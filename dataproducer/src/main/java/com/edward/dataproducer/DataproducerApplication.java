package com.edward.dataproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.edward.dataproducer.service.PriceDataProducer;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DataproducerApplication implements CommandLineRunner{
	
	@Autowired
	private PriceDataProducer priceDataProducer;

	public static void main(String[] args) {
		SpringApplication.run(DataproducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		priceDataProducer.produceData();
	}
	
}
