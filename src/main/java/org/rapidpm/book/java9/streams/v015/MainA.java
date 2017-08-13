package org.rapidpm.book.java9.streams.v015;

import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextStreamWithDuplicates;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.book.java9.streams.utils.DemoData;
import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final List<Character> resultA = nextStreamWithDuplicates().collect(flatMapping(new Function<Pair<String, String>, Stream<Character>>() {
      @Override
      public Stream<Character> apply(Pair<String, String> pair) {
        return pair.getT1().chars().mapToObj(value -> (char) value);
      }
    } , toList()));

    System.out.println("resultA " + resultA);

    final List<Character> resultB = nextStreamWithDuplicates()
        .collect(flatMapping(pair -> pair.getT1().chars().mapToObj(value -> (char) value) , toList()));

    System.out.println("resultB " + resultB);

    final Set<Character> resultC = nextStreamWithDuplicates()
        .collect(flatMapping(pair -> pair.getT1().chars().mapToObj(value -> (char) value) , toSet()));

    System.out.println("resultC " + resultC);

  }
}
