package com.java8;

import java.util.function.BooleanSupplier;

/*
 * BooleanSupplier represents a supplier of boolean-valued results.
 * 
 * */
public class BooleanSupplierExample {
	public static void main(String[] args) {
		  BooleanSupplier bs = () -> true;
		    System.out.println(bs.getAsBoolean());
		    
		    
		    BooleanSupplier bs1 = () -> false;
		    System.out.println(bs1.getAsBoolean());
	}
}
