package org.rapidpm.book.java9.streams.chap_01.v105;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class MainC {
  public static void main(String[] args) {
    final List<String> demoValues
        = Arrays.asList("A", "B", "C", "D", "E");

    final String reduceA = demoValues.stream()
                                .reduce("X_" , (v1 , v2) -> {
                                  System.out.println("v1 -> " + v1);
                                  System.out.println("v2 -> " + v2);
                                  return v1.concat(v2) + "#";
                                });
    System.out.println(reduceA);

    final String reduceB = demoValues.parallelStream()
                                .reduce("X_" , (v1 , v2) -> {
                                  System.out.println("v1 -> " + v1);
                                  System.out.println("v2 -> " + v2);
                                  return v1.concat(v2) + "#";
                                });
    System.out.println(reduceB);
  }
}
