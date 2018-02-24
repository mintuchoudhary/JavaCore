package com.java8;

/* Functional Interface - interface which has only one abstract method 
 * Note: It can have default methods as well
 * */
 
@FunctionalInterface
interface A {
	  void show(String name);
	  default void dis()
	  {
		  System.out.println("dss");
	  }
	  
	  default void dis2()
	  {
		  System.out.println("dss");
	  }
	   
}

@FunctionalInterface
interface A1 {
	  public void show();
	  
	   
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

public class FunctionalInterfaceWithStaticDefaultFeature {
	public static void main(String[] args) {
     
		AWithDefaultStatic.show2();
	
		
		A obj= (name11)-> { System.out.println("value passed in param: "+name11);};
	
		obj.show("Mintu");
		
		A1 obj1= new A1(){
			public void show()
			{
				System.out.println("a1 show methods");
			}
			
		};
		//above can be written in lamda expression as
		obj1= ()-> {System.out.println("a1 show method by lambda");};
		//or
		obj1= ()-> System.out.println("a1 show method by lambda - 2");
     	// or
		obj1= ()-> System.out.println("a1 show method by lambda - 2");
		obj1.show();
		 
	}
}