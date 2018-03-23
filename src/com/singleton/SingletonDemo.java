package com.singleton;
class Singleton {
	
	//Lasy Initilization 
	private static Singleton singletonObj = null;
	public String s;

	private Singleton() {
		s = "value set for s in private constructor";
	}

	public static Singleton getInstance() {
		if (singletonObj == null)

			singletonObj = new Singleton();

		return singletonObj;
	}
}

public class SingletonDemo {
	public static void main(String args[]) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		Singleton obj3 = Singleton.getInstance();

		System.out.println(obj1 + " " + obj2 + " " + obj3);
		System.out.println("value of s=" + obj1.s);
		obj1.s = "new value";
		System.out.println("value of s=" + obj2.s);

		System.out.println(obj1 + " " + obj2);
	}
}
