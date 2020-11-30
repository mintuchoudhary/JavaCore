package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatch {

    public static void main(String[] args) {

        String regex = "\\b(\\d{3})\\d{7}\\b";
        Pattern p = Pattern.compile(regex);
        String source = "3342449027, 2339829, and 6152534734";

        Matcher m = p.matcher(source);

        while (m.find()) {
            String val = m.group();
            String val2 = m.group(1);
            System.out.println("Val: " + val + ", Val2: " + val2);
        }
    }
}
/**
 Val: 3342449027, Val2: 334
 Val: 6152534734, Val2: 615
 */