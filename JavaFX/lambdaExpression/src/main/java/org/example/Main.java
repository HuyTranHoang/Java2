package org.example;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> predicate = i -> i > 0;

        System.out.println(predicate.test(-1));

        Supplier<Integer> supplier = () -> 5;

    }
}