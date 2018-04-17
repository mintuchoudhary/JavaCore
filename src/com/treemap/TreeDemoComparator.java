
package com.m2.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeDemoComparator {
	public static void main(String[] args) {
		//Error : com.m2.treemap.Emp cannot be cast to java.lang.Comparable
		Map<Emp, Department> treeMap = new TreeMap<Emp, Department>(new EmpComparator());
		treeMap.put(new Emp(1, "Mintu"), new Department(100, "IT"));
		treeMap.put(new Emp(2, "Meg"), new Department(200, "Product"));
		treeMap.put(new Emp(3, "Sandy"), new Department(300, "Dev"));
		treeMap.put(new Emp(4, "Sam"), new Department(500, "OS"));
		treeMap.put(new Emp(5, "Fazl"), new Department(600, "Marketing"));

		Iterator itr = treeMap.entrySet().iterator();
		while (itr.hasNext()) {
			Entry entry = (Entry) itr.next();
			System.out.println(
					((Emp) entry.getKey()).getName() + " " + ((Department) entry.getValue()).getDeptName());
		}
	}
}
