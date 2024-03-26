package com.example.ShinHanAc.ch17.exam05;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("This is a java book", "Lamda Excpreesions", "Java8 supports lambda expressions");
        list.stream()
                .filter(s -> s.toLowerCase().contains("java")) //system 객체를 필터링 한 후
                .forEach(System.out::println); //foreach한 것
    }
}
