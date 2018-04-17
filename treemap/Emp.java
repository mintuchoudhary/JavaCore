package com.m2.treemap;

public class Emp {
	private int id;
	private String name;

	public Emp(int i, String name) {
		this.id=i;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	@Override
	public int compareTo(Object e) {
		return this.name.compareTo(((Emp)e).name);
	}*/
}
