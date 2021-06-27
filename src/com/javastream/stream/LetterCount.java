package com.javastream.stream;

import java.util.Arrays;

public class LetterCount {

    public static void main(String[] args) {
        getTotalNumberOfLettersOfNamesLongerThanFive("A", "b", "c");
    }

    //Array elemanlarini al => stream()
    //5ten uzun isimleri filtrele => filter()
    //Geri kalan listedeki tum harflerin sayisini getir => mapToInt()
    //harf sayilarini topla => sum()
    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
         //O(n)
         return Arrays.stream(names)
                 .filter(name -> name.length() > 5) //Stream<String> if (name.length() > 5)
                 .mapToInt(String::length) //Stream<Integer>
                 .sum();
    }

}
