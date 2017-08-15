package org.rapidpm.book.java9.streams.chap_01.v102;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final Stream<Integer> streamA = Stream.of(1 , 2 , 3 , 4 , 5);

    final Stream<Float> streamB = streamA.map(new Function<Integer, Float>() {
      @Override
      public Float apply(Integer i) {
        return Float.valueOf(i);
      }
    });

    final Stream<String> streamC = streamB.map(v -> String.valueOf(v));

    //alternativ
    final Stream<String> stream = Stream
        .of(1 , 2 , 3 , 4 , 5)
        .map(Float::valueOf)
        .map(String::valueOf);


  }
}
