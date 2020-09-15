package com.java8;

import java.util.ArrayList;
import java.util.List;

/*
 * Method references help to point to methods by their names. A method reference is described using "::" symbol.
 * 
Reference to a static method.
Reference to an instance method.
Reference to a constructor.

*/
public class MethodReferenceFeature {
	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();

		names.add("Mahesh");
		names.add("Suresh");
		//names.forEach(i->System.out.println(i));
		// WITH METHOD REFERENCE
		names.forEach(System.out:: println);
	
           // Referring static method  
           Sayable sayable = MethodReference::saySomething;  
           // Calling interface method  
           sayable.say();  
 
         Thread t2=new Thread(MethodReference::saySomething);  
          t2.start();  

           
         MethodReference methodReference = new MethodReference(); // Creating object  
          // Referring non-static method using reference  
            Sayable sayable2 = methodReference::printSomething;  
          // Calling interface method  
            sayable2.say();  

             Messageable hello = Message::new;  
            hello.getMessage("Hello");  
      }
}

//static method reference
interface Sayable{  
    void say();  
}  
class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
   public void printSomething() {
      System.out.println("in print method");
   } 
}  

interface Messageable{  
    Message getMessage(String msg);  
}  
class Message{  
    Message(String msg){  
        System.out.print(msg);  
    }  
}

