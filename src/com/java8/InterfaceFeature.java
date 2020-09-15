package com.java8;

//Functional Interface
@FunctionalInterface
interface AB {
	  void show(String name);
	  
	   
}


interface ABWithDefaultStatic {

	default void show() {
		System.out.println("in default show");
	}
	
	static void show2()
	{
		System.out.println("in static method");
	}

}


public class InterfaceFeature {
	public static void main(String[] args) {
     
		ABWithDefaultStatic.show2();


		AB obj= (name11)-> { System.out.println("value passed in param: "+name11);};
	
		obj.show("Mintu");
		 
	}
}