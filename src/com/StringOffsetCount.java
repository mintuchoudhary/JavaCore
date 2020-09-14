package com.java8;


/**
 * offset: is the index of the given array to start from
 * count: is the number of items in the array to be processed
 */
public class StringOffsetCount {
    public static void main(String[] args) {
        int arr[] = {65, 66, 67, 68};
        String asciValue = new String(arr, 0, 4);  //String(int[] codePoints, int offset, int count)

        System.out.println(asciValue); //ABCD

        String asciValue2 = new String(arr, 1, 3);
        // offset = start of index, in place of 3, 4 will give StringIndexOutOfBoundsException

        System.out.println(asciValue2); //BCD

        String asciValue3 = new String(arr, 2, 2);

        System.out.println(asciValue3); //CD

        String asciValue4 = new String(arr, 2, 1);

        System.out.println(asciValue4); //C

        String asciValue5 = new String(arr, 3, 1);

        System.out.println(asciValue5); //D
    }
}
