package org.rapidpm.book.java9.streams.v017;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStreamWithDuplicates;

import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import org.rapidpm.book.java9.streams.utils.DemoData;

/**
 *
 */
public class MainA {


  public static void main(String[] args) {
    final Integer resultA = nextIntegerStreamWithDuplicates()
        .collect(collectingAndThen(toSet() , new Function<Set<Integer>, Integer>() {
      @Override
      public Integer apply(Set<Integer> integers) {
        return integers.stream().collect(Collectors.summingInt(new ToIntFunction<Integer>() {
          @Override
          public int applyAsInt(Integer value) {
            return value;
          }
        }));
      }
    }));

    System.out.println("resultA = " + resultA);

    final Integer resultB = nextIntegerStreamWithDuplicates()
        .collect(collectingAndThen(toSet() ,
                                   set -> (Integer) set.stream().mapToInt(value -> value).sum()));

    System.out.println("resultB = " + resultB);

  }



}
