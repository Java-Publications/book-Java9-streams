package org.rapidpm.book.java9.streams.v004;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.book.java9.streams.utils.DemoData;
import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainA {

  public static Stream<Pair<String,String>> nextStream(){
    return DemoData.nextStreamWithDuplicates();
  }

  public static void main(String[] args) {
    final Map<String, List<Pair<String, String>>> mapA = nextStream()
        .collect(Collectors.groupingBy(new Function<Pair<String, String>, String>() {
          @Override
          public String apply(Pair<String, String> p) {
            return p.getT1();
          }
        }));
    System.out.println("mapA = " + mapA);

    final Map<String, List<Pair<String, String>>> mapB = nextStream()
        .collect(Collectors.groupingBy(Pair::getT1));
    System.out.println("mapB = " + mapB);


  }
}
