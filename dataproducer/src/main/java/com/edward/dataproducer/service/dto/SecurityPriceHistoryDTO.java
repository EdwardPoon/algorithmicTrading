package com.edward.dataproducer.service.dto;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecurityPriceHistoryDTO {
	
    public String id;
	private String securityNumber;
	private LocalDateTime executionTime;
	private BigDecimal executionPrice;
	
	public SecurityPriceHistoryDTO() {
		
	}
	public SecurityPriceHistoryDTO(String securityNumber,LocalDateTime executionTime,BigDecimal executionPrice) {
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
	@Override
    public String toString() {
        return String.format(
                " SecurityPriceHistoryDTO[id=%s, securityNumber='%s', executionTime='%s',executionPrice=%s]",
                id, securityNumber, executionTime,executionPrice);
    }
}
