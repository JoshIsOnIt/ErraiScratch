package com.blinco.errai;

import java.math.BigDecimal;

/**
 * This Reflection class should be created by an annotated processor, and would have
 * the added benefit of created publicly usable static final Strings for all
 * properties of the bean.
 * 
 * The motivation for creating this class is that it contains functionality that is
 * needed (and currently duplicated) by both the errai-marshalling and errai-databinding.
 * 
 * @author joshblinick
 *
 */
public class PriceRateDtoReflection extends BaseReflectionOf<PriceRateDto> {

	static public final String LongDescription = "longDescription";
	static public final String Product = "product";
	static public final String RateUnit = "rateUnit";
	static public final String Description = "description";
	static public final String Products = "products";
	static public final String Rate = "rate";
	static public final String Id = "id";
	
	public PriceRateDtoReflection() {
		addPropertyTypes( String.class, LongDescription);
		addPropertyTypes( String.class, Product);
		addPropertyTypes( String.class, RateUnit);
		addPropertyTypes( String.class, Description);
		addPropertyTypes( String.class, Products);
		addPropertyTypes( BigDecimal.class, Rate);
		addPropertyTypes( String.class, Id);
		addPropertyTypes( String.class, "this");
	}
		
	@Override
	public Object get( PriceRateDto entity, String property ) {
		
		switch( property ) {
		
			case Id:
				return entity.getId();
			case Rate:
				return entity.getRate();
			default:
				throw new RuntimeException();
		}		
	}
	
	@Override
	public void set(PriceRateDto entity, String property, Object value) {
		
		switch( property ) {
		
			case Id:
				entity.setId( (Long) value);
			case Rate:
				entity.setRate( (BigDecimal) value); 
			default:
				throw new RuntimeException();
		}	
	}

	@Override
	public PriceRateDto makeNew() {
		return new PriceRateDto();
	}
}