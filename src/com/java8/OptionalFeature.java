package com.java8;

import java.util.Optional;

/*
 * Developers had to carefully validate variables which can generate NullPointerExpection
 * */
public class OptionalFeature {
	public static void main(String[] args) {

		String s="222";
		Optional<String> optional = Optional.empty();
		
		System.out.println(optional.ofNullable(s)); // this is return Optional.empty
		
		System.out.println(optional.ofNullable(s).isPresent()); // this is return true if element is not null
		
		System.out.println(optional.empty()); // this is return Optional.empty
		//System.out.println(optional.of(s));  //This will throw NullPointer if s is null

		Optional<String> value= optional.ofNullable(s);
		
		String notNullValue= value.orElse("set value if null");  // if value is null then change to 'set value if null'
 
		System.out.println(notNullValue);

	}
}
