package com.blinco.errai;

import org.jboss.errai.marshalling.client.Marshalling;
import org.jboss.errai.marshalling.client.api.Marshaller;
import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

/**
 * This marshaller could *ideally* be generated from an annotation processor.
 * 
 * @author joshblinick
 *
 */
public class PriceRateDtoMarshaller extends BaseMarshaller<PriceRateDto> {

	public PriceRateDtoMarshaller() {
		super(PriceRateDto.class, new PriceRateDtoReflection());
	}

	private PriceRateDto[] EMPTY_ARRAY = new PriceRateDto[0];
	
	@Override
	public PriceRateDto[] getEmptyArray() {
		return EMPTY_ARRAY;
	}

	/**
	 * This could actually probably all go into the base class
	 */
	@Override
	protected void marshall(PriceRateDto a0, MarshallingSession a1, StringBuilder sb) {

		StringCollector sc = new StringCollector();
		
		for( String property : reflect().getProperties() ) {
			Class c = reflect().getClassForProperty(property);
			Object v = reflect().get(a0, property);
					
			Marshaller m = Marshalling.getMarshaller(c);
			sc.append("\"");
			sc.append(property);
			sc.append("\":");
			sc.append(m.marshall(v, a1));
		}
		sb.append(sc);
	}

	/**
	 * This could actually probably all go into the base class
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void demarshall(EJValue a0, EJObject obj, MarshallingSession a1, PriceRateDto target) {

		for( String property : reflect().getProperties() ) {
			EJValue v = obj.get(property);
			if( v != null && !v.isNull() ) {

				Class c = reflect().getClassForProperty(property);
				Marshaller m = Marshalling.getMarshaller(c);
				Object realValue = m.demarshall(v, a1); 
				reflect().set(target, property, realValue);
			}
		}
	}

	@Override
	void lazyInit() {
		// TODO Auto-generated method stub
		
	}
}