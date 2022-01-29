package com.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Inteview Ques: How will you sort data based on FirstName and then on LastName
 */

public class MultipleSortComparator {

    public static void main(String[] args) {
        ArrayList<Employee> employees = getUnsortedEmployeeList();

        //Compare by first name and then last name
        Comparator<Employee> compareByName = Comparator
                .comparing(Employee::getFirstName)
                .thenComparing(Employee::getLastName);

        List<Employee> sortedEmployees = employees.stream()
                .sorted(compareByName)
                .collect(Collectors.toList());

        System.out.println(sortedEmployees); //sort by stream

        Collections.sort(employees,new EmpComparator());
        System.out.println("sorted employee by comparator:::"+employees);
    }
    private static ArrayList<Employee> getUnsortedEmployeeList() {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(2l, "Lokesh", "Gupta"));
        list.add(new Employee(1l, "Alex", "Gussin"));
        list.add(new Employee(4l, "Brian", "Sux"));
        list.add(new Employee(5l, "Neon", "Piper"));
        list.add(new Employee(3l, "David", "Beckham"));
        list.add(new Employee(7l, "Alex", "Beckham"));
        list.add(new Employee(6l, "Brian", "Suxena"));
        return list;
    }
}
class EmpComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Employee emp1 =(Employee)o1;
        Employee emp2 =(Employee)o2;
        int c = emp1.getFirstName().compareTo(emp2.getFirstName()); //returns 0 when equals
        if(c==0) {
            c =  emp1.getLastName().compareTo(emp2.getLastName());
        }
    return c;
    }
}
class Employee {
    long id;
    String firstName;
    String lastName;

    public Employee(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}