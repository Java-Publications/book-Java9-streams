package org.rapidpm.book.java9.streams.chap_00.v012;

import static java.util.stream.Collectors.maxBy;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextStreamWithDuplicates;

import java.util.Comparator;
import java.util.Optional;

import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final Optional<Pair<String, String>> resultA = nextStreamWithDuplicates()
        .collect(maxBy(new Comparator<Pair<String, String>>() {
      @Override
      public int compare(Pair<String, String> o1 , Pair<String, String> o2) {
        return 0;
      }
    }));
    System.out.println("resultA = " + resultA);

    final Optional<Pair<String, String>> resultB = nextStreamWithDuplicates()
        .collect(maxBy((o1 , o2) -> 0));
    System.out.println("resultB = " + resultB);

    final Optional<Pair<String, String>> resultC = nextStreamWithDuplicates().max((o1 , o2) -> 0);
    System.out.println("resultC = " + resultC);

  }
}
