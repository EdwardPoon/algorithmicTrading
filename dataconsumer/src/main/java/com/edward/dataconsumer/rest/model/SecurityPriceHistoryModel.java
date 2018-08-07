package com.edward.dataconsumer.rest.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

public class SecurityPriceHistoryModel {

    public String id;
	private String securityNumber;
	private DateTime executionTime;
	private BigDecimal executionPrice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSecurityNumber() {
		return securityNumber;
	}
	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}
	public DateTime getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(DateTime executionTime) {
		this.executionTime = executionTime;
	}
	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}
	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}
	
	
}
