package com.blinco.errai;

import java.util.Set;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

/**
 * Interface for Reflect Entities.  Any entity marked with {@link Bindable} or {@link Portable}
 * should generate a Reflect object that implements this interface.
 * 
 * Could also add a @Reflect annotation to force the creation of a reflect object.  The
 * reflect object should not use any GWT specific stuff (GWT.create()).
 * 
 * @author joshblinick
 *
 * @param <T>
 */
public interface ReflectionOf<T> {

	public T makeNew();
	public Object get( T entity, String property );
	public void set( T entity, String property, Object value );
	public Set<String> getProperties();
	public Class getClassForProperty( String property );
}