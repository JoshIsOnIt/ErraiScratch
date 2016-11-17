package com.blinco.errai;

import java.util.Map;

import org.jboss.errai.databinding.client.BindableProxyAgent;
import org.jboss.errai.databinding.client.PropertyType;

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