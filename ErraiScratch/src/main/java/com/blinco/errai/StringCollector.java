package com.blinco.errai;

import java.util.ArrayList;
import java.util.List;

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