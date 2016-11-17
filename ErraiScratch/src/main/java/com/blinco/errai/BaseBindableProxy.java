package com.blinco.errai;

import java.util.List;

import org.jboss.errai.databinding.client.BindableProxy;

public interface BaseBindableProxy<B> extends BindableProxy<B> {

	public ReflectionOf<B> reflect();
	public B getBean();
	
	default public Object get(String propertyName)  {
		return reflect().get(getBean(), propertyName);
	}
	
	default public void set(String propertyName, Object value) {
		reflect().set(getBean(), propertyName, value);
	}
	
	default public B deepUnwrap() {
		
		B c = reflect().makeNew();
		
		for( String property : reflect().getProperties() ) {
			Object v = reflect().get(getBean(), property);
			
			if( v instanceof List ) {
				List l = (List) v;
				for( Object o : l ) {

					if( o instanceof BindableProxy )
						l.add(((BindableProxy) o).deepUnwrap());
					else
						l.add(o);
				}
			}
		}
		return c;
	}
	
}