package com;

/**
 * If you dont override the display method in main the you will compilation error at implements I1,I2 line
 * hello
 * test class 2
 */
interface I1 {
    default void display(){
        System.out.println( "i1" );
    }
}

interface I2 {
    default void display(){
        System.out.println( "i2" );
    }


}

public class InterfaceDefaultHandle implements I1,I2 { //this will not compile without override method : display

    @Override
    public void display() {
        System.out.println( "test class 2" );
    }

    public static void main(String[] args) {

        System.out.println( "hello") ;
       new InterfaceDefaultHandle().display();
    }
}


