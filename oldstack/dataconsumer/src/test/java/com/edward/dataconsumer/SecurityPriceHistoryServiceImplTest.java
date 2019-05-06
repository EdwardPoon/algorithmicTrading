package com.edward.dataconsumer;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.edward.dataconsumer.repository.SecurityPriceHistoryRepository;
import com.edward.dataconsumer.service.SecurityPriceHistoryService;
import com.edward.dataconsumer.service.impl.SecurityPriceHistoryServiceImpl;
import com.edward.dataconsumer.service.mapper.SecurityPriceHistoryDTOEntityMapper;

@RunWith(SpringRunner.class)
public class SecurityPriceHistoryServiceImplTest {
	
	@TestConfiguration
    static class SecurityPriceHistoryServiceImplTestContextConfiguration {
  
        @Bean
        public SecurityPriceHistoryService securityPriceHistoryService() {
            return new SecurityPriceHistoryServiceImpl();
        }
    }
 
    @Autowired
    private SecurityPriceHistoryService securityPriceHistoryService;
    @MockBean
    private SecurityPriceHistoryRepository repository;
    @MockBean
	private SecurityPriceHistoryDTOEntityMapper mapper;
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        List<BigDecimal> priceList = new ArrayList<BigDecimal>();
        priceList.add(BigDecimal.valueOf(5));
        priceList.add(BigDecimal.valueOf(6));
        priceList.add(BigDecimal.valueOf(7));
        BigDecimal averagePrice = securityPriceHistoryService.calculateAveragePrice(priceList);
      
         assertThat(averagePrice)
          .isEqualTo(BigDecimal.valueOf(6));
     }

}
