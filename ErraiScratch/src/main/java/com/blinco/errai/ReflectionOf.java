package com.blinco.errai;

import java.util.Set;

public interface ReflectionOf<T> {

	public T makeNew();
	public Object get( T entity, String property );
	public void set( T entity, String property, Object value );
	public Set<String> getProperties();
	public Class getClassForProperty( String property );
}