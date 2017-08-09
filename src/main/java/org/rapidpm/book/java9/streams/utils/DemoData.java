package org.rapidpm.book.java9.streams.utils;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Pair;

/**
 *
 */
public interface DemoData {

  static Stream<Pair<String, String>> nextStream() {
    return Stream.of(
        new Pair<>("A" , "A") ,
        new Pair<>("B" , "B") ,
        new Pair<>("C" , "C")
    );
  }

  static Stream<Pair<String, String>> nextStreamWithDuplicates() {
    return Stream.of(
        new Pair<>("A" , "A") ,
        new Pair<>("B" , "B") ,
        new Pair<>("B" , "B") ,
        new Pair<>("C" , "C") ,
        new Pair<>("C" , "C") ,
        new Pair<>("C" , "C")
    );
  }

  static Stream<Integer> nextIntegerStream(){
    return IntStream.range(1,10).boxed();
  }

  static Stream<String> nextStringStreamWithDuplicates(){
    return Stream.of(
        "A", "B", "C", "D",
        "A", "B", "C", "D",
        "y", "x", "v", "g",
        "y", "x", "v", "g",
        "y", "x", "v", "g"
    );
  }

}
