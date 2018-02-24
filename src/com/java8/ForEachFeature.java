package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/*
 * It is a functional interface defined in java.util.function package. It contains an abstract accept() and a default andThen() method.  
 * */
public class ForEachFeature {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(2,4,67,8,89,9);
	
	Consumer<Integer> action = new Consumer<Integer>(){
		 @Override 
		public void accept(Integer i){			   
			   System.out.println(i);
		   } 
	};
	
	list.forEach(action);
	
	//OR
	
	list.forEach(element -> System.out.println("element="+element));
}
}
