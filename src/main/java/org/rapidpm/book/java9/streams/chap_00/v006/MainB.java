package org.rapidpm.book.java9.streams.chap_00.v006;

import static org.rapidpm.book.java9.streams.utils.DemoData.nextStringStreamWithDuplicates;

import java.util.stream.Collectors;

/**
 *
 */
public class MainB {
  public static void main(String[] args) {


    final String resultA = nextStringStreamWithDuplicates()
        .collect(Collectors.joining(","));
    System.out.println("resultA = " + resultA);



  }
}
