package com.kim.algoStudy;


import java.util.AbstractMap;
import java.util.Map;

import static java.util.Map.entry;


public class test {
    public static void main(String[] args) {


        Map<String, Object> test = Map.ofEntries(
                entry("Rapahel", 30),
                entry("Olivia",25),
                entry("Thibaut",26)
        );

    }
}
