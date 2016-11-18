package com.blinco.errai;

import java.util.ArrayList;
import java.util.List;

/**
 * Advantage of the StringCollector, we can create the stringbuilder once, and the right
 * size, so it doesn't have to keep doing an internal clone and copy, which is what
 * the StringBuilder does when it runs out of room.
 * 
 * @author joshblinick
 *
 */
public class StringCollector {

	List<String> strings = new ArrayList<>();
	int length = 0;

	public void append( String str ) {
		strings.add(str);
		length += str.length();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder(length);
		for( String s : strings )
			sb.append(s);
		
		return sb.toString();
	}
}