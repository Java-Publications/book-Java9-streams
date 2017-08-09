package org.rapidpm.book.java9.streams.v006;

import static org.rapidpm.book.java9.streams.utils.DemoData.nextStringStreamWithDuplicates;

import java.util.stream.Collectors;

import org.rapidpm.book.java9.streams.utils.DemoData;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {


    final String resultA = nextStringStreamWithDuplicates()
                                   .collect(Collectors.joining());
    System.out.println("resultA = " + resultA);



  }
}