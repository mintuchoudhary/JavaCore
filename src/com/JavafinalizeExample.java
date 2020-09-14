package com.java8;

public class JavafinalizeExample {
    public static void main(String[] args)
    {
        JavafinalizeExample obj = new JavafinalizeExample();
        System.out.println(obj.hashCode());
        obj = null;
        // calling garbage collector
        //System.gc();           // Either methods call be called to invoke finalize method
        Runtime.getRuntime().gc();
        System.out.println("end of garbage collection");

    }
    @Override
    protected void finalize()
    {
        System.out.println("finalize method called");
    }
}