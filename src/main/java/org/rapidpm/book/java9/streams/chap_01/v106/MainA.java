package org.rapidpm.book.java9.streams.chap_01.v106;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {
    Stream
        .of(1,2,3,4,5,6,7,8,9)
        .takeWhile(new Predicate<Integer>() {
          @Override
          public boolean test(Integer integer) {
            return integer < 5;
          }
        }).forEach(System.out::print);

    Stream
        .of(1,2,3,4,5,6,7,8,9)
        .takeWhile(i -> i < 5)
        .forEach(System.out::print);

  }
}
