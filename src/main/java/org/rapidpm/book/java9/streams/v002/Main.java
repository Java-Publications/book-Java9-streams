package org.rapidpm.book.java9.streams.v002;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class Main {


  public static Stream<Pair<String, String>> nextStream() {
    return Stream.of(
        new Pair<>("A" , "A") ,
        new Pair<>("B" , "B") ,
        new Pair<>("C" , "C")
    );
  }

  public static void main(String[] args) {

    List<Pair<String,String>> listA = nextStream()
        .collect(Collectors.toCollection(()-> new LinkedList<>()));

    List<Pair<String,String>> listB = nextStream()
        .collect(Collectors.toCollection(LinkedList::new));
  }
}
