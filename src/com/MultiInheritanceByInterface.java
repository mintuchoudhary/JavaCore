package com;

/**
 * A class can implement any number of interfaces. In this case there is no ambiguity even
 * though both the interfaces are having same method. Why? Because methods in an interface
 * are always abstract by default,
 * which doesn’t let them give their implementation (or method definition ) in interface itself.
 */
public class MultiInheritanceByInterface {
    public static void main(String[] args) {
        MultipleInheritance multipleInheritance = new MultipleInheritance();
        multipleInheritance.myMethod();
    }

}

interface X
{
    public void myMethod();
}
interface Y
{
    public void myMethod();
}
class MultipleInheritance implements X, Y
{
    public void myMethod()
    {
        System.out.println("Implementing more than one interfaces");
    }

}