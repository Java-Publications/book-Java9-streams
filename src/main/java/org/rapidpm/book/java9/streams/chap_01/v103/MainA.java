package org.rapidpm.book.java9.streams.chap_01.v103;

import java.util.stream.Stream;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {

    final Stream<Integer> stream = Stream
        .of(1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9)
        .filter(v -> v % 2 == 0)
        .filter(v -> v > 2);
  }
}
