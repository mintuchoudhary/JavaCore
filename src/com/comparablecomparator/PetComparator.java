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
	
/*
//For multiple comparision i.e will compare other parameter if first parameter is same
public int compare(Object o1, Object o2) {

    String x1 = ((Pet) o1).getPetType();
    String x2 = ((Pet) o2).getPetType();
    int sComp = x1.compareTo(x2);

    if (sComp != 0) {
       return sComp;
    } else {
       Integer pid1 = ((Pet) o1).getPetId();
       Integer pid2 = ((Pet) o2).getPetId();
       System.out.println("---"+((Pet) o1).getPetType());
       System.out.println("----"+((Pet) o2).getPetType());
       return pid1.compareTo(pid2);
    }
}

*/

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
