package com.blinco.errai;

import org.jboss.errai.marshalling.client.api.Marshaller;
import org.jboss.errai.marshalling.client.api.MarshallingSession;
import org.jboss.errai.marshalling.client.api.json.EJObject;
import org.jboss.errai.marshalling.client.api.json.EJValue;

public abstract class BaseMarshaller<T> implements Marshaller<T> {

	ReflectionOf<T> reflect;
	Class<T> clazz;
	
	public BaseMarshaller( Class<T> clazz, ReflectionOf<T> reflect ) {
		this.clazz = clazz;;
		this.reflect = reflect;
	}

	@Override
	public T demarshall(EJValue a0, MarshallingSession a1) {

		lazyInit();
	    EJObject obj = a0.isObject();
	    if (obj == null) {
	      return null;
	    }
	    String objId = obj.get("^ObjectID").isString().stringValue();
	    if (a1.hasObject(objId)) {
	      return a1.getObject(clazz, objId);
	    }
	    
	    T t = reflect.makeNew();
	    a1.recordObject(objId, t);
	    demarshall(a0, obj, a1,t);
	    return t;
	}
	
	@Override
	public String marshall(T a0, MarshallingSession a1) {

	    lazyInit();
	    if (a0 == null) {
	      return "null";
	    }
	    final boolean ref = a1.hasObject(a0);
	    final StringBuilder json = new StringBuilder("{\"^EncodedType\":\"com.blinco.report.api.row.ReportRenderTypeRow\",\"^ObjectID\"");
	    json.append(":\"").append(a1.getObject(a0)).append("\"");
	    if (ref) {
	      return json.append("}").toString();
	    }

	    marshall(a0, a1, json);
	    return json.toString();
	}
	
	abstract protected void demarshall( EJValue a0, EJObject obj, MarshallingSession a1, T target );
	abstract protected void marshall( T a0, MarshallingSession a1, StringBuilder sb );
	abstract void lazyInit();
	
	public ReflectionOf<T> reflect() {
		return reflect;
	}
}
