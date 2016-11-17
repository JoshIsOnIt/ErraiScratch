package com.blinco.errai;

import java.math.BigDecimal;

public class PriceRateDto {

	Long id;
	BigDecimal rate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
}
