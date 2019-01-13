package com.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String[] args) {
		Map<Employee, Department> treeMap = new TreeMap<Employee, Department>();
		treeMap.put(new Employee(1, "Mintu"), new Department(100, "IT"));
		treeMap.put(new Employee(2, "Meg"), new Department(200, "Product"));
		treeMap.put(new Employee(3, "Sandy"), new Department(300, "Dev"));
		treeMap.put(new Employee(4, "Sam"), new Department(500, "OS"));
		treeMap.put(new Employee(5, "Fazl"), new Department(600, "Marketing"));

		Iterator itr = treeMap.entrySet().iterator();
		while (itr.hasNext()) {
			Entry entry = (Entry) itr.next();
			System.out.println(
					((Employee) entry.getKey()).getName() + " " + ((Department) entry.getValue()).getDeptName());
		}
	}
}

class Employee implements Comparable {
	private int id;
	private String name;

	public Employee(int i, String name) {
		this.id = i;
		this.name = name;
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

	@Override
	public int compareTo(Object e) {
		return this.name.compareTo(((Employee) e).name);
	}
}