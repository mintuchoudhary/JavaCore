package com.m2.treemap;

import java.util.Comparator;

public class EmpComparator implements Comparator<Emp> {

	@Override
	public int compare(Emp e1, Emp e2) {
		return e1.getName().compareTo(e1.getName());
	}

}
