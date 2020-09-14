package com.java8;

/**
 * being unchecked exception the child class can have higher order exception
 * Still there wont be any exeption, but for checked exception it would give compile time error
 */

public class SuperClassRuntimeException {
    public static void main(String[] args) {
        Super obj = new Base();
        obj.method();

    }
}

class Super {
    void method() throws NullPointerException {
        System.out.println("super class");
    }
}

class Base extends Super {
    void method() throws RuntimeException { //higher than super class
        System.out.println("base class");
    }
}