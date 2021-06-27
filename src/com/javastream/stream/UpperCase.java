package com.javastream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UpperCase {

    public static void main(String[] args) {

        mapToUppercase("A", "b", "c");
    }


    public static Collection<String> mapToUppercase(String... names) {
        Collection<String> uppercaseNames = new ArrayList<>();
        for(String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        return uppercaseNames;
    }

    //Array elemanlarinin tamamini al => stream()
    //buyuk harflere cevir => map()
    //liste olarak geri don => collect()
    public static Collection<String> mapToUppercase2(String... names) {
        return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
    }
}
