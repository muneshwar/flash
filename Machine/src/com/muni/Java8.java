package com.muni;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Java8 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Touche","Deloitte","PWC","Ernest");
	
	for(String name:names) {
		System.out.println("--"+name);
	}
	
	// Comparing using the lambda expressions
	Collections.sort(names,(a,b)-> a.compareTo(b));
	
	for(String name:names) {
		System.out.println("---"+name);
	}
	
	}

}
