package org.rapidpm.book.java9.streams.v003;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.function.BinaryOperator;
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
    final Map<String, String> mapA = nextStream()
        .collect(toMap(Pair::getT1 ,
                       p -> p.getT2().toLowerCase() ,
                       new BinaryOperator<String>() {
                         @Override
                         public String apply(String s1 , String s2) {
                           return s1 + " - " + s2;
                         }
                       }

                 )
        );

    System.out.println("mapA = " + mapA);

    final Map<String, String> mapB = nextStream()
        .collect(toMap(Pair::getT1 ,
                       p -> p.getT2().toLowerCase() ,
                       (s1 , s2) -> s1 + " - " + s2));

    System.out.println("mapB = " + mapB);


  }
}
