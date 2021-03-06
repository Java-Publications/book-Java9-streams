package org.rapidpm.book.java9.streams.chap_00.v008;

import static java.util.stream.Collectors.averagingInt;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.function.ToIntFunction;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {

    final Double valueA = nextIntegerStream()
        .collect(averagingInt(new ToIntFunction<Integer>() {
      @Override
      public int applyAsInt(Integer v) {
        return v;
      }
    }));
    System.out.println("valueA = " + valueA);

    final Double valueB = nextIntegerStream().collect(averagingInt(v -> v));
    System.out.println("valueB = " + valueB);


  }
}
