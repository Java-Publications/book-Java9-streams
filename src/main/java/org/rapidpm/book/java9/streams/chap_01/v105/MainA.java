package org.rapidpm.book.java9.streams.chap_01.v105;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {
    final List<String> demoValues
        = Arrays.asList("A" , "B" , "C" , "D" , "E");

    demoValues
        .stream()
        .reduce(String::concat)
        .ifPresent(System.out::println);

    demoValues
        .parallelStream()
        .reduce(String::concat)
        .ifPresent(System.out::println);
  }
}
