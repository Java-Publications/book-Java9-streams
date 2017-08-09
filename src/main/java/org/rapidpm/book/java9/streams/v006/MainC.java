package org.rapidpm.book.java9.streams.v006;

import static org.rapidpm.book.java9.streams.utils.DemoData.nextStringStreamWithDuplicates;

import java.util.stream.Collectors;

/**
 *
 */
public class MainC {
  public static void main(String[] args) {
    final String resultA = nextStringStreamWithDuplicates()
        .collect(Collectors.joining(",", "PREFIX", "SUFFIX"));
    System.out.println("resultA = " + resultA);
  }
}
