package com.java8;

//Functional Interface
@FunctionalInterface
interface A {
	  void show(String name);
	  
	   
}


interface AWithDefaultStatic {

	default void show() {
		System.out.println("in default show");
	}
	
	static void show2()
	{
		System.out.println("in static method");
	}

}

class B implements AWithDefaultStatic {
	void display() {
		System.out.println("in display");
	}
}

public class InterfaceFeature {
	public static void main(String[] args) {
     
		AWithDefaultStatic.show2();
	
		
		A obj= (name11)-> { System.out.println("value passed in param: "+name11);};
	
		obj.show("Mintu");
		 
	}
}