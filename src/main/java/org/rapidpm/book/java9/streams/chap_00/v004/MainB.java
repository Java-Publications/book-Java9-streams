package org.rapidpm.book.java9.streams.chap_00.v004;

import static java.util.stream.Collectors.groupingBy;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.book.java9.streams.utils.DemoData;
import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainB {

  public static Stream<Pair<String, String>> nextStream() {
    return DemoData.nextStreamWithDuplicates();
  }

  public static void main(String[] args) {
    final Map<String, Set<Pair<String, String>>> mapA = nextStream()
        .collect(groupingBy(Pair::getT1,
                            Collectors.toSet()));
    System.out.println("mapA = " + mapA);
  }

}
