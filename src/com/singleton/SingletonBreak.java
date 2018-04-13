package com.java8;

import java.lang.reflect.Constructor;

/*
 Reflection can be caused to destroy singleton property of singleton class
 Solution:
 To overcome issue raised by reflection, enums are used because java ensures internally that enum value is instantiated only once. Since java Enums are globally accessible, they can be used for singletons. Its only drawback is that it is not flexible i.e it does not allow lazy initialization.


public enum Singleton 
{
  INSTANCE;
}


*/
class Singleton {
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

public class SingletonBreak {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName("com.java8.Singleton");
		c.getConstructors();
		  System.out.println(c.getName());  
	 
		    Constructor<Singleton> constructor = c.getDeclaredConstructor(new Class[0]);
	        constructor.setAccessible(true);
	        Singleton singleton = constructor.newInstance(new Object[0]);
	        System.out.println(singleton);
	        
	        Singleton singleton1 = constructor.newInstance(new Object[0]);
	        System.out.println(singleton1);
	        Singleton singleton2 = constructor.newInstance(new Object[0]);
	        System.out.println(singleton2);
	        
	        
	}

}
