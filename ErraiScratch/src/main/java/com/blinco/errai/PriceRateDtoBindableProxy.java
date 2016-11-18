package com.blinco.errai;

import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.Generated;

import org.jboss.errai.databinding.client.BindableProxyAgent;
import org.jboss.errai.databinding.client.PropertyType;

/**
 * Sample of Generated BindableProxy.  I don't see why this couldn't be generated from 
 * an annotation processor as well.
 * 
 * Uses the Reflect object and default implementations in the BaseBindableProxy interface.
 * 
 * @author joshblinick
 *
 */
@Generated("From ...")
public class PriceRateDtoBindableProxy extends PriceRateDto implements BaseBindableProxy<PriceRateDto> {

	PriceRateDtoReflection reflect = new PriceRateDtoReflection();
	BindableProxyAgent<PriceRateDto> agent;
	
	public PriceRateDtoBindableProxy( PriceRateDto target ) {
		agent = new BindableProxyAgent<PriceRateDto>(this, target);
		//agent.populateFromReflection(reflect);
	}
	
	@Override
	public Object unwrap() {
		return agent.target;
	}

	@Override
	public Long getId() {
		return agent.target.getId();
	}

	@Override
	public void setId(Long id) {
        Long oldValue = agent.target.getId();
        agent.target.setId(id);
        agent.updateWidgetsAndFireEvent(false, reflect.Id, oldValue, id);
	}

	@Override
	public BigDecimal getRate() {
		return agent.target.getRate();
	}

	@Override
	public void setRate(BigDecimal rate) {
        BigDecimal oldValue = agent.target.getRate();
        agent.target.setRate(rate);
        agent.updateWidgetsAndFireEvent(false, reflect.Rate, oldValue, rate);
	}
	
	@Override
	public Map<String, PropertyType> getBeanProperties() {
//		return reflect.getProperties();
		return null;
	}

	@Override
	public BindableProxyAgent<PriceRateDto> getBindableProxyAgent() {
		return agent;
	}

	
	
	@Override
	public void updateWidgets() {
		agent.updateWidgetsAndFireEvents();
	}

	@Override
	public ReflectionOf<PriceRateDto> reflect() {
		return reflect;
	}

	@Override
	public PriceRateDto getBean() {
		return agent.target;
	}
	
	@Override
	public int hashCode() {
        return agent.target.hashCode();
    }

	@Override
    public String toString() {
        return agent.target.toString();
    }
}