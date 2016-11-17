package com.blinco.errai;

import java.util.HashMap;
import java.util.Set;

public abstract class BaseReflectionOf<T> implements ReflectionOf<T> {

	HashMap<String,Class> propertyTypes = new HashMap<String, Class>();
	
	public T clone( T entity ) {
		
		T c = makeNew();
		
		for( String p : propertyTypes.keySet() ) {
			Object v = get(entity,p);
			set(c, p, v);
		}
		return c;
	}

	public void addPropertyTypes( Class clazz, String... properties ) {
		
		for( String p : properties ) 
			propertyTypes.put(p,clazz);
	}

	@Override
	public Set<String> getProperties() {
		return propertyTypes.keySet();
	}
	@Override
	public Class getClassForProperty(String property) {
		return propertyTypes.get(property);
	}
}
