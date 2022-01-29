package com.java8;

import java.util.HashMap;
import java.util.function.BiConsumer;

class BiConsumerWithMap {
    public static void main(String args[]) {
        HashMap<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> consumer = map::putIfAbsent; //check if key+value is present
        consumer.accept(1, null);
        consumer.accept(2, "two");
        consumer.accept(1, "ONE");
        consumer.accept(2, "TWO");
        System.out.println(map);

    }
}