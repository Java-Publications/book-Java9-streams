package org.rapidpm.book.java9.streams.chap_00.v003;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import org.rapidpm.book.java9.streams.utils.DemoData;
import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainC {

  public static Stream<Pair<String, String>> nextStream() {
    return DemoData.nextStreamWithDuplicates();
  }

  public static void main(String[] args) {
    final Map<String, String> mapA = nextStream()
        .collect(toMap(Pair::getT1 ,
                       p -> p.getT2().toLowerCase() ,
                       (s1 , s2) -> s1 + " - " + s2 ,
                       TreeMap::new));

    System.out.println("mapA = " + mapA);
  }

}
