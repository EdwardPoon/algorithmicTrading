package com.edward.dataconsumer.repository.entity;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

public class SecurityPriceHistory {
	
	@Id
    public String id;
	
	private String securityNumber;
	private DateTime executionTime;
	private BigDecimal executionPrice;
	
	public SecurityPriceHistory() {
		
	}
	
	public SecurityPriceHistory(String securityNumber,DateTime executionTime,BigDecimal executionPrice) {
		this.securityNumber = securityNumber;
		this.executionTime = executionTime;
		this.executionPrice = executionPrice;
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
	@Override
    public String toString() {
        return String.format(
                "SecurityPriceHistory[id=%s, securityNumber='%s', executionTime='%s',executionPrice=%s]",
                id, securityNumber, executionTime,executionPrice);
    }
	

}
