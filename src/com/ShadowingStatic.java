
/**
 * Here the subclass method will not be called as the method has been shadowed by parent due to static.
 * If method is not static then B fun() method will be called
 * Varible of superclass will be called as objec
 */
class A {
    int a=10;
    static void fun() {
        System.out.println("A.fun()");
    }
}

class B extends A {
    int a=20;
    static void fun() {
        System.out.println("B.fun()");
    }
}

public class ShadowingStatic {
    public static void main(String args[]) {
        A obj = new B();
        obj.fun();  // prints A.fun()
        System.out.println(obj.a);
    }
}