package org.ptrading.datatransformer.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class EquityDataFeed {
	
	private String instrumentCode;
	
	private LocalDate date;
	
	private Instant time;
	
	private BigDecimal bidPrice;
	
	private Instant bidTime;
	
	private BigDecimal bidSize;
	
	private BigDecimal askPrice;
	
	private Instant askTime;
	
	private BigDecimal askSize;

	public EquityDataFeed(String instrumentCode, LocalDate date, Instant time, BigDecimal bidPrice, Instant bidTime,
			BigDecimal bidSize, BigDecimal askPrice, Instant askTime, BigDecimal askSize) {
		super();
		this.instrumentCode = instrumentCode;
		this.date = date;
		this.time = time;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
		this.bidSize = bidSize;
		this.askPrice = askPrice;
		this.askTime = askTime;
		this.askSize = askSize;
	}

	public String getInstrumentCode() {
		return instrumentCode;
	}

	public void setInstrumentCode(String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public BigDecimal getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Instant getBidTime() {
		return bidTime;
	}

	public void setBidTime(Instant bidTime) {
		this.bidTime = bidTime;
	}

	public BigDecimal getBidSize() {
		return bidSize;
	}

	public void setBidSize(BigDecimal bidSize) {
		this.bidSize = bidSize;
	}

	public BigDecimal getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}

	public Instant getAskTime() {
		return askTime;
	}

	public void setAskTime(Instant askTime) {
		this.askTime = askTime;
	}

	public BigDecimal getAskSize() {
		return askSize;
	}

	public void setAskSize(BigDecimal askSize) {
		this.askSize = askSize;
	}
	

}
