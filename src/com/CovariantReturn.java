package com;

/**
 * Covariant return type refers to return type of an overriding method.
 * It allows to narrow down return type of an overridden method
 * without any need to cast the type or check the return type.
 * Covariant return type works only for NON-PRIMITIVE return types.
 */
class SuperClass {
    SuperClass get() {
        System.out.println("SuperClass");
        return this;
    }
}

class Tester extends SuperClass {
    @Override
    Tester get() {  //instead of SuperClass return changes to Tester
        System.out.println("SubClass");
        return this;
    }

}

public class CovariantReturn {
    public static void main(String[] args) {
        SuperClass tester = new Tester();
        tester.get();
    }

}
