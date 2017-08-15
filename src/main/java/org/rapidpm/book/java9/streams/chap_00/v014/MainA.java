package org.rapidpm.book.java9.streams.chap_00.v014;

import static java.util.stream.Collectors.partitioningBy;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStreamWithDuplicates;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {


    final Map<Boolean, List<Integer>> collectA
        = nextIntegerStreamWithDuplicates()
        .collect(partitioningBy(e -> e >= 5));

    System.out.println("collectA = " + collectA);

    final Map<Boolean, Set<Integer>> collectB = nextIntegerStreamWithDuplicates()
        .collect(partitioningBy(e -> e >= 5 , Collectors.toSet()));

    System.out.println("collectB = " + collectB);




  }
}
