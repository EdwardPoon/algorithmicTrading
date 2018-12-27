package com.edward.dataconsumer.rest.model;

import java.math.BigDecimal;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityPriceHistoryModel {

    public String id;
	private String securityNumber;
	
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	private LocalDateTime executionTime;
	
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
	public LocalDateTime getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(LocalDateTime executionTime) {
		this.executionTime = executionTime;
	}
	public BigDecimal getExecutionPrice() {
		return executionPrice;
	}
	public void setExecutionPrice(BigDecimal executionPrice) {
		this.executionPrice = executionPrice;
	}
	
	
}
