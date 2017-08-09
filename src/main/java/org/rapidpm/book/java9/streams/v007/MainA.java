package org.rapidpm.book.java9.streams.v007;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.List;
import java.util.function.Function;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final String resultA = nextIntegerStream()
        .collect(collectingAndThen(toList() , new Function<List<Integer>, String>() {
          @Override
          public String apply(List<Integer> v) {
            return v.toString().substring(7);
          }
        }));
    System.out.println("resultA = " + resultA);

    final String resultB
        = nextIntegerStream()
        .collect(collectingAndThen(toList() ,
                                   v -> v.toString().substring(7)));
    System.out.println("resultB = " + resultB);
  }
}
