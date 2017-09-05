package org.rapidpm.book.java9.streams.chap_01.v107;

import java.util.stream.Stream;

/**
 *
 */
public class MainA {


  public static void main(String[] args) {

    Stream.iterate(3 ,
                   v -> v + 2)
          .limit(4)
          .forEach(System.out::println);

    Stream.iterate(3 ,
                   v -> v < 10 ,
                   v -> v + 2)
          .forEach(System.out::println);

  }
}
