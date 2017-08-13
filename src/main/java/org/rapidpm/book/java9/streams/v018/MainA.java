package org.rapidpm.book.java9.streams.v018;

import static java.util.stream.Collectors.partitioningBy;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStreamWithDuplicates;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {

    final Map<Boolean, List<Integer>> resultA = nextIntegerStreamWithDuplicates()
        .collect(partitioningBy(i -> i < 5));
    System.out.println("resultA = " + resultA);

    final Map<Boolean, List<Integer>> resultA_1 = resultA.get(true).stream().collect(partitioningBy(i -> i % 2 == 0));
    final Map<Boolean, List<Integer>> resultA_2 = resultA.get(false).stream().collect(partitioningBy(i -> i % 2 == 0));

    final Map<Boolean, Map<Boolean, List<Integer>>> resultB = nextIntegerStreamWithDuplicates()
        .collect(partitioningBy(i -> i < 5 , partitioningBy(i -> i % 2 == 0)));
    System.out.println("resultB = " + resultB);


  }

}
