package com.utilities;

import java.util.*;

import static java.lang.Integer.compare;

/**
 * The important points about Java TreeSet class are:
 * TreeSet class contains unique elements only like HashSet
 * TreeSet class doesn't allow null element.
 * TreeSet class is non synchronized.
 * TreeSet class maintains ascending order.
 * For user defined class it should implement Comparable
 * Error when object has not implemented Comparable: java.lang.ClassCastException: com.utilities.Person cannot be cast to java.lang.Comparable
 */

public class TestHashSet {

    public static void main(String[] args) {

        TreeSet<String> al = new TreeSet<String>();
        al.add("Sandy");
        al.add("Dee");
        al.add("Mintu");
        al.add("Mintu");
        //Traversing elements
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Person p1 = new Person("Mintu", 1, "Pune", "Kharadi");
        Person p2 = new Person("Meg", 2, "Pune", "Pune");
        Person p3 = new Person("Dee", 3, "Mum", "Kondhwa");
        Person p4 = new Person("Sandy", 1, "Pune", "Dhanori");
        Person p5 = new Person("Dee", 3, "Mum", "PUN");

        //   System.out.println(p1.equals(p4));

        TreeSet<Person> persons = new TreeSet();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

      //  System.out.println(persons);
        Iterator it = persons.iterator();
        while (it.hasNext()) {
            Person values = (Person) it.next();
            System.out.print(values.personId);
            System.out.println(values.personName);
        }

    }
}

class Person implements Comparable {
    public String personName;
    public int personId;
    public String personCity;
    public String personStreetName;

    public Person(String personName, int personId, String personCity, String personStreetName) {
        this.personName = personName;
        this.personId = personId;
        this.personCity = personCity;
        this.personStreetName = personStreetName;
    }

    @Override
    public int compareTo(Object obj) {
        Person per = (Person) obj;

        //    return compare(this.personId, per.personId);// compare by id
        return this.personName.compareTo(per.personName); //compare by name
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId &&
                Objects.equals(personName, person.personName) &&
                Objects.equals(personCity, person.personCity)/* &&
                Objects.equals(personStreetName, person.personStreetName)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, personId, personCity, personStreetName);
    }
}
/**
 * Output:
 * Dee
 * Mintu
 * Sandy
 * 3Dee
 * 2Meg
 * 1Mintu
 * 1Sandy
 */
