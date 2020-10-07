package com.utilities;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sharrahc on 19-03-2018.
 */
public class MapStreamSort implements Serializable {
    public static void main(String[] args) {
        Map<String, Integer> numberMap = new HashMap<>();
        numberMap.put("Three", 3);
        numberMap.put("Two", 2);
        numberMap.put("One", 1);
        numberMap.put("Five", 5);
        numberMap.put("Four", 4);

        List valueSortlist = numberMap.entrySet().stream().sorted(Comparator.comparing(x -> x.getValue().intValue())).collect(Collectors.toList());
        List keySortlist = numberMap.entrySet().stream().sorted(Comparator.comparing(x -> x.getKey())).collect(Collectors.toList());
        System.out.println("Sort by Value:" + valueSortlist);
        System.out.println("Sort by Key:" + keySortlist);
    }
}
