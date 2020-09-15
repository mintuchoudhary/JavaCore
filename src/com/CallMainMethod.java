package com;

public class CallMainMethod {
    static int count = 0;

    public static void main(String args[]) {
        if (count < 3) {
            System.out.println(count);
            count++;
            main(null);
        } else {
            System.out.println("else=" + count);

            return;
        }
        System.out.println("hello world" + count);
    }
}
/*
0
1
2
else=3
hello world3
hello world3
hello world3

 */