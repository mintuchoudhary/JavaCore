package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StaticBlockExample {

    public static void main(String args[]) {
        System.out.println(T.x); // T loaded will not be called as Object of T class is not created here, with new it will run
        List<Boolean> list = new ArrayList();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(0) instanceof Boolean);
    }

}

class T {
    public static final int x = 10;

    static {
        System.out.println("T loaded"); //this will not be invoked unless Object of T class is created using new
    }
}
/*
10
3
[true, false, true]
true
*
* */