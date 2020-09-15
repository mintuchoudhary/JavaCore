
/*
@author: Mintu Choudhary
* Output:
5
5
10

* */

public class PassByValue {
    public static void main(String[] args) {
        int x = 5;
        change(x);
        System.out.println(x); // This will print 5

        Test t = new Test(5);
        // Reference is passed and a copy of reference  is created in change()

        change2(t);
        System.out.println(t.x); // This will print 5

        change3(t);
        System.out.println(t.x); // This will print 10
    }

    public static void change(int x) {

        x = 10;
    }

    public static void change2(Test t) {
        /* We changed reference to refer some other location
         now any changes made to reference are not reflected
         back in main */
        t = new Test();
        t.x = 10;
    }

    public static void change3(Test t) {

        /*  This change() doesn't change the reference, it only
          changes member of object referred by reference  */

        t.x = 10;
    }
}

class Test {
    int x;

    Test(int i) {
        x = i;
    }

    Test() {
        x = 0;
    }
}

