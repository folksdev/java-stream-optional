package com.javastream.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        a.stream()
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i + 1));

    }
}
