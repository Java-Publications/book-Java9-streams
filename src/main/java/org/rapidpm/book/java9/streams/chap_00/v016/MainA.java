package org.rapidpm.book.java9.streams.chap_00.v016;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.toList;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStreamWithDuplicates;

import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {

    final List<Integer> resultA = nextIntegerStreamWithDuplicates()
        .collect(filtering(new Predicate<Integer>() {
          @Override
          public boolean test(Integer v) {
            return v > 5;
          }
        } , toList()));

    System.out.println("resultA = " + resultA);

    final List<Integer> resultB = nextIntegerStreamWithDuplicates()
        .collect(filtering(v -> v > 5 , toList()));

    System.out.println("resultB = " + resultB);
  }
}
