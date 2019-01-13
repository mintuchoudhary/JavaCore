
package com.treemap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.m2.treemap.Emp.Department; 

public class TreeDemoComparator {
	public static void main(String[] args) {
		//Error : com.m2.treemap.Emp cannot be cast to java.lang.Comparable
		Map<Emp, Department> treeMap = new TreeMap<Emp, Department>(new EmpComparator());
		treeMap.put(new Emp(1, "Mintu"), new Department(100, "Dev"));
		treeMap.put(new Emp(2, "Megha"), new Department(200, "Director"));
		treeMap.put(new Emp(3, "Sandy"), new Department(300, "Dev"));
		treeMap.put(new Emp(4, "Sam"), new Department(500, "OS"));
		treeMap.put(new Emp(5, "Fazl"), new Department(600, "Marketing"));

	  System.out.println("After sorting:");
		Set<Emp> keys= treeMap.keySet();
	    for (Emp key : keys) {
		 System.out.println(key.getName()+" "+treeMap.get(key).getDeptName());
	    }
	}
}

class EmpComparator implements Comparator<Emp> {

	@Override
	public int compare(Emp e1, Emp e2) {
		return e1.getName().compareTo(e2.getName());
	}

}
 class Emp { 
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

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + "]";
	}


}

