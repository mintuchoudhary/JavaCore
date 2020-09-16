package com.waystocreateobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 1) Using new Keyword
 * 2) Reflection: Using Class.forName() - New Instance
 * 3) Using clone() method
 * 4) Using deserialization
 * 5) Reflection: Using Constructor.getDeclaredConstructor() - newInstance() method of Constructor class
 * 
 * */
public class ObjectCreationExample implements Cloneable, Serializable {
   static int count=1;
	public static void main(String[] args) {
		// 1) Using new Keyword
		ObjectCreationExample newObj = new ObjectCreationExample();
		newObj.method();

		// 2) Using Class.forName New Instance
		try {
			ObjectCreationExample classObj = (ObjectCreationExample) Class
					.forName("com.waystocreateobject.ObjectCreationExample").newInstance();
			classObj.method();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 3) Using clone() method // Need to implements Cloneable
		ObjectCreationExample cloneObj = null;
		try {
			cloneObj = (ObjectCreationExample) newObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		cloneObj.method();

		// 4) Using deserialization
		try {
			FileOutputStream fos = new FileOutputStream("ObjectCreationExample.txt"); // FileNotFoundException
			ObjectOutputStream oos = new ObjectOutputStream(fos); // IOException

			oos.writeObject(newObj);

			FileInputStream fis = new FileInputStream("ObjectCreationExample.txt"); // FileNotFoundException
			ObjectInputStream ois = new ObjectInputStream(fis); // IOException

			ObjectCreationExample serialObj = (ObjectCreationExample) ois.readObject();

			serialObj.method();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 5) Using newInstance() method of Constructor class

	 	try {
			Constructor<ObjectCreationExample> constructor = ObjectCreationExample.class.getDeclaredConstructor();

			ObjectCreationExample newInstanceConstObj = constructor.newInstance();

			newInstanceConstObj.method();

		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		} 

	}

	void method() {
		System.out.println("in method called for "+count++ +" time");
	}

	/*
	 * @Override protected Object clone() throws CloneNotSupportedException { //
	 * return super.clone(); }
	 */
}
