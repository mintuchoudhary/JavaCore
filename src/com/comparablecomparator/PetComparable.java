package com.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Mintu Choudhary
 * Comparable: It allow itself to compare with another similar object. Need to override compareTo() method
 * 
 * */
public class PetComparable implements Comparable {

	private int petId;
	String petType;

	public PetComparable(int petId, String petType) {
		this.petId = petId;
		this.petType = petType;
	}

	@Override
	public int compareTo(Object petObject) {
		PetComparable pet = (PetComparable) petObject;
		// natural alphabetic order by type
		// returns 0 for equals, + int for greater than, and - int for less than
		return this.petType.compareTo(pet.petType);
 
	}

	public static void main(String args[]) {
     List petlist=new ArrayList<PetComparable>();
     petlist.add(new PetComparable(4, "Rabbit"));
     petlist.add(new PetComparable(1, "Parrot"));
     petlist.add(new PetComparable(2, "Fish"));
     petlist.add(new PetComparable(3, "Peagon"));    
	
     System.out.println("Before sorting:");
     petlist.forEach(i -> System.out.println(((PetComparable)i).petType));
     
     Collections.sort(petlist);
     System.out.println("After sorting:");
     petlist.forEach(i -> System.out.println(((PetComparable)i).petType));
	}
}
