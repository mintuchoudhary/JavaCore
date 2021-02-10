package com;

/**
 * Trick is this will try to look for variable of the class, and normal will try to look for local variable inside the method
 * 15
 * 20
 */
public class NumericTrick {
    final int num = 10;

    public static void main(String args[]) {
        NumericTrick sv = new NumericTrick();
        sv.display();
    }

    public void display() {
        int num = 12;
        Runnable r = new Runnable() {
           int num = 15;

            public void run() {
                int num = 20;
                System.out.println(  this.num); // this is inside ananomous class so will look for super class
                System.out.println(  num);  //if the local variable is not present then it will look for class variable
            }
        };
        r.run();
    }
}