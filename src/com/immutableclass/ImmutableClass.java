package com.immutableclass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Hashcode and equals problem
 * Overriding hashcode() and equals() will print element found where as commenting equals() method - will run Object equals method (i.e false) which results as not found
 * 
 * */
final class Emp {

	final private int id;
	final private String name;
	private final Add add;

	Emp(int id, String name, Add add) {
		this.id = id;
		this.name = name;

		Add a = new Add();
		a.setCity(add.getCity());
		this.add = a;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Add getAdd() {

		Add a1 = new Add();

		a1.setCity(add.getCity());

		return a1;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", add=" + add + "]";
	}

}

class Add {
	String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Add [city=" + city + "]";
	}

}

public class ImmutableClass {
	public static void main(String[] args) throws Exception {

		Add a = new Add();
		a.setCity("pune");

		Emp e = new Emp(1, "mak", a);

		System.out.println(e);

		// a.setCity("mumbai");

		e.getAdd().setCity("delhi");

		System.out.println(e);
	}
}
