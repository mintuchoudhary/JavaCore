package com.utilities.mock;

/**
 * Static - First loaded when the class is loaded by child class (order: Super --> Child)
 * Block {} - Is loaded then the object is created before constructor
 * Constructor - Lastly loaded (order: Super --> Child)
 */
// E C 1 (WHEN main class is loaded)  Before A B D M (when object is created) After
class LoadingOrderFromStaticToBlock extends Reptile {
    {
        System.out.println("M");
    }
    static {
        System.out.println("1");
    }

    public static void main(String args[]) {
        System.out.println("Before");
        new LoadingOrderFromStaticToBlock();
        System.out.println("After");
    }
}


class Reptile extends Animal {
    static {
        System.out.println("C");
    }
    Reptile() {
        System.out.println("D");
    }
}

class Animal {
    static {
        System.out.println("E");
    }
    {
        System.out.println("A");
    }
    public Animal() {
        System.out.println("B");
    }
}

