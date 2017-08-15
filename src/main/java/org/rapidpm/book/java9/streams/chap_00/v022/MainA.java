package org.rapidpm.book.java9.streams.chap_00.v022;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.concat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {

  //Type of the elements that will be collected
  //Type of the internal data structure that will be used during collecting
  //final output Type

  public static void main(String[] args) {

    final Collector<String, List<String>, Set<String>> collector = new Collector<>() {
      @Override
      public Supplier<List<String>> supplier() {
        return ArrayList::new;
      }

      @Override
      public BiConsumer<List<String>, String> accumulator() {
        return List::add;
      }

      @Override
      public BinaryOperator<List<String>> combiner() {
        return (listA , listB) -> concat(listA.stream(), listB.stream()).collect(toList());
      }

      @Override
      public Function<List<String>, Set<String>> finisher() {
        return HashSet::new;
      }

      @Override
      public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
      }
    };

    Stream.of("Hello", "Collector",
              "Hello", "Collector")
          .collect(collector)
          .forEach(System.out::println);

  }
}
