package com.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetComparator implements Comparator {
@Override
	public int compare(Object o1, Object o2) {
		Pet pet1 = (Pet) o1;
		Pet pet2 = (Pet) o2;

		return pet1.getPetType().compareTo(pet2.getPetType());
	}

	public static void main(String args[]) {
		List petlist = new ArrayList<Pet>();
		petlist.add(new Pet(4, "Rabbit"));
		petlist.add(new Pet(1, "Parrot"));
		petlist.add(new Pet(2, "Fish"));
		petlist.add(new Pet(3, "Peagon"));

		System.out.println("Before sorting:");
		petlist.forEach(i -> System.out.println(((Pet) i).petType));

		Collections.sort(petlist, new PetComparator());  //Note to give new PetComparator()
		System.out.println("After sorting:");
		petlist.forEach(i -> System.out.println(((Pet) i).petType));
	}

}
