package org.rapidpm.book.java9.streams.chap_00.v013;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.List;
import java.util.function.Function;

import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {

    final List<Pair<String, String>> listA = nextIntegerStream()
        .collect(mapping(new Function<Integer, Pair<String, String>>() {
          @Override
          public Pair<String, String> apply(Integer v) {
            return new Pair<>("OK", String.valueOf(v));
          }
        } , toList()));
    System.out.println("listA = " + listA);

    final List<Pair<String, String>> listB = nextIntegerStream()
        .collect(mapping(v -> new Pair<>("OK", String.valueOf(v)) , toList()));
    System.out.println("listB = " + listB);

    final List<Pair<String, String>> listC = nextIntegerStream()
        .map(v -> new Pair<>("OK" , String.valueOf(v)))
        .collect(toList());
    System.out.println("listC = " + listC);



  }
}
