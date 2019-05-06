package com.edward.dataconsumer.rest.model;

import java.math.BigDecimal;

public class AveragePriceModel {
	
	private BigDecimal averagePrice;
	private String successMessage;
	private String errorMessage;
	
	public AveragePriceModel(BigDecimal averagePrice,String successMessage,String errorMessage) {
		this.averagePrice = averagePrice;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		
	}
	
	public BigDecimal getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(BigDecimal averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
