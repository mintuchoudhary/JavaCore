package com.java8;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/*
 *  A sequence of elements supporting sequential and parallel aggregate operations.
 * */
class Person {
	int id;
	String name;

	Person(int id, String name) {
		this.id = id;
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

}

public class StreamAPiFeature {
	public static void main(String[] args) {
  Stream<Integer> stream = Stream.empty();
  
  Stream<Integer> stream2 = Stream.empty();
  
  List<Integer> list = Arrays.asList(22, 4, 67, 8, 89, 9,2,46);
  
  Stream<Integer> streamList= list.stream(); 
  //If streamList is used for 2nd time we will get: java.lang.IllegalStateException: stream has already been operated upon or closed
  System.out.println("----------------Get even -------------");
  
  list.stream().filter(element-> element%2==0).forEach(System.out::println);
  
  System.out.println("----------------After sorting-------------");
  list.stream().filter(element-> element%2==0).sorted().forEach(System.out::println);
  
  //Note : Here if parallelStream() is used, it will not guarantee the output in sorted order as parallel execution will perform operation on multiple elements at same time.
  
  Map<Person,Integer> personMap = new HashMap<Person,Integer>();
  personMap.put(new Person(1,"Mintu"),1);
  personMap.put(new Person(2,"Sandeep"),2);
  personMap.put(new Person(3,"Maahi"),3);
  personMap.put(new Person(4,"Meg"),4);
  
  
  
//    System.out.println(list.stream().isParallel());
 //   list.forEach(i -> System.out.println(i));

   // stream2 = list.parallelStream().forEach(p-> System.out.println(p));
  
	}
}
