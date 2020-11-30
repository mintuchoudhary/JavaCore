package com;

public class PrivateInnerClass {
    public static void main(String[] args) {
        OuterClass obj = new OuterClass();
        obj.display();
    }
}

class OuterClass {
    int a = 10;

    void display() {
        System.out.println("outer class");
        InnerClass innerClass = new InnerClass();
        innerClass.display();
    }

    private class InnerClass {
        void display() {
            System.out.println("inner class " + a);
        }
    }
}
/**
 outer class
 inner class 10
 */