package com.edward.dataconsumer;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.edward.dataconsumer.repository.SecurityPriceHistoryRepository;
import com.edward.dataconsumer.repository.entity.SecurityPriceHistory;
import com.edward.dataconsumer.service.mapper.SecurityPriceHistoryDTOEntityMapper;

@SpringBootApplication
@EnableMongoRepositories
public class DataconsumerApplication  implements CommandLineRunner{
	
	@Autowired
	private SecurityPriceHistoryRepository repository;
	@Autowired
	private SecurityPriceHistoryDTOEntityMapper mapper;

	public static void main(String[] args) {
		SpringApplication.run(DataconsumerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		//repository.deleteAll();
		repository.save(new SecurityPriceHistory("AAPL", DateTime.now(),BigDecimal.valueOf(123.14)));
		//repository.save(new SecurityPriceHistory("AAPL", DateTime.now(),BigDecimal.valueOf(124.34)));
		//repository.save(new SecurityPriceHistory("AAPL", DateTime.now(),BigDecimal.valueOf(134.44)));
		//repository.save(new SecurityPriceHistory("AAPL", DateTime.now(),BigDecimal.valueOf(155.34)));
		//repository.save(new SecurityPriceHistory("AMAZ", DateTime.now(),BigDecimal.valueOf(1123.34)));
		
		System.out.println("===  print all ==");
		
		for (SecurityPriceHistory securityPriceHistory : repository.findAll()) {
			System.out.println(securityPriceHistory);
		}
		System.out.println("===  print page ==");
		
		PageRequest pageRequest = PageRequest.of(0, 3,
                new Sort(Direction.ASC, "executionTime"));
		Page<SecurityPriceHistory> page = repository.findPageBySecurityNumber("AAPL",pageRequest);
		
		for (SecurityPriceHistory securityPriceHistory :page.getContent()) {
			System.out.println(securityPriceHistory);
			
			System.out.println( mapper.entityToDTO(securityPriceHistory));
			
		}
		
		
	}
}
