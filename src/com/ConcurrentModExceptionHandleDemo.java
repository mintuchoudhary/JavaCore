package com.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Java Program to demonstrate how to deal with * ConcurrentModificationException. * Unlike the name suggests, this error can come even if only * one thread is modifying the collection e.g. List. * It happens when you modify collection * while iterating over it e.g. adding new element or removing elements. * * If you want to remove elements while traversing list then * make sure you use Iterator's remove() method or not ArrayList's remove() * method() to avoid ConcurrentModificationExcetpion. * * @author WINDOWS 8 *
 */
public class ConcurrentModExceptionHandleDemo {


    public static void main(String args[]) {
        List<String> listOfPhones = new ArrayList<String>(Arrays.asList("iPhone 6S", "iPhone 6", "iPhone 5", "Samsung Galaxy 4", "Lumia Nokia"));
        System.out.println("list of phones: " + listOfPhones);
        // Iterating and removing objects from list
        // This is wrong way, will throw ConcurrentModificationException
        for (String phone : listOfPhones) {
            if (phone.startsWith("iPhone")) {
                // listOfPhones.remove(phone); // will throw exception
            }
        }

        // The Right way, iterating elements using Iterator's remove() method

        Iterator itrs = listOfPhones.iterator();
        while (itrs.hasNext()) {
            String ph = (String) itrs.next();
            if (ph.startsWith("iPhone")) {
                itrs.remove();
            }
        }

        // The Right way, iterating elements using Iterator's remove() method

        /*for (Iterator<String> itr = listOfPhones.iterator(); itr.hasNext(); ) {
            String phone = itr.next();
            if (phone.startsWith("iPhone")) {
                // listOfPhones.remove(phone); // wrong again
                itr.remove(); // right call
            }
        }*/
        System.out.println("list after removal: " + listOfPhones);
    }
}
/**
 * list of phones: [iPhone 6S, iPhone 6, iPhone 5, Samsung Galaxy 4, Lumia Nokia]
 * list after removal: [Samsung Galaxy 4, Lumia Nokia]
 */
