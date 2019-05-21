package org.ptrading.datatransformer;

import org.ptrading.datatransformer.service.DataTransformService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PtradingDataTransformerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(PtradingDataTransformerApplication.class, args);
		DataTransformService dataTransformService = ctx.getBean(DataTransformService.class);
		dataTransformService.transformDataFeed();
	}

}
