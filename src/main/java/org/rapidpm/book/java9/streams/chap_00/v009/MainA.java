package org.rapidpm.book.java9.streams.chap_00.v009;

import static java.util.stream.Collectors.summarizingInt;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.IntSummaryStatistics;
import java.util.function.ToIntFunction;

/**
 *
 */
public class MainA {


  public static void main(String[] args) {
    final IntSummaryStatistics statisticsA = nextIntegerStream()
        .collect(summarizingInt(new ToIntFunction<Integer>() {
      @Override
      public int applyAsInt(Integer v) {
        return v;
      }
    }));

    System.out.println("statisticsA = " + statisticsA);

    final IntSummaryStatistics statisticsB = nextIntegerStream()
        .collect(summarizingInt(v -> v));

    System.out.println("statisticsB = " + statisticsB);
  }
}
