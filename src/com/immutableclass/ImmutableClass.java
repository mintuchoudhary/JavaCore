package com.immutableclass;

import java.util.*;

/*
 * Hashcode and equals problem
 * Overriding hashcode() and equals() will print element found where as commenting equals() method - will run Object equals method (i.e false) which results as not found
 * 
 * */
final class Emp {

	final private int id;
	final private String name;
	private final Add add;
	private final Date date;

	Emp(int id, String name, Add add, Date date) {
		this.id = id;
		this.name = name;
        this.date=date;
		Add a = new Add();
		a.setCity(add.getCity());
		this.add = add;

	}

	public Date getDate() {
		return date;
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
		return "Emp [id=" + id + ", name=" + name + ", add=" + add + " date="+date+"]";
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

		Emp e = new Emp(1, "mak", a,new Date());

		System.out.println(e);

		// a.setCity("mumbai");

		e.getAdd().setCity("delhi");
        Emp e1=e;
		e1.getAdd().setCity("delhi");
		System.out.println(e1);
	}
}
