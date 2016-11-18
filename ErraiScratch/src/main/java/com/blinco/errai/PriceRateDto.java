package com.blinco.errai;

import java.math.BigDecimal;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

/**
 * Sample Dto to use to illustrate BindableProxy and Marshaller
 *  
 * @author joshblinick
 *
 */
@Portable @Bindable
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