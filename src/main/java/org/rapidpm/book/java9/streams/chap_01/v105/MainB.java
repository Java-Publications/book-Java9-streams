package org.rapidpm.book.java9.streams.chap_01.v105;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MainB {
  public static void main(String[] args) {
    final List<String> demoValues
        = Arrays.asList("A" , "B" , "C" , "D" , "E");

    final String reduceA = demoValues
        .stream()
        .reduce("#" , String::concat);
    System.out.println("reduceA = " + reduceA);

    final String reduceB = demoValues
        .parallelStream()
        .reduce("#" , String::concat);
    System.out.println("reduceB = " + reduceB);


  }
}
