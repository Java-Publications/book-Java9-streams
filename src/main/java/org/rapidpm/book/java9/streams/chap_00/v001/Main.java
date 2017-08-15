package org.rapidpm.book.java9.streams.chap_00.v001;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class Main {
  public static void main(String[] args) {
    final List<Pair<String,String>> generateDemoValues
        = generateDemoValues();
    //Stream from Values
    final Stream<String> fromValues
        = Stream.of("A" , "B");
    //Stream from Array
    final String[] strings = {"A" , "B"};
    final Stream<String> fromArray = Stream.of(strings);
    //Stream from List
    final Stream<Pair<String,String>> fromList
        = generateDemoValues.stream();
    //Stream from String
    final Stream<String> abc = Stream.of("ABC");
    final Stream<IntStream> of = Stream.of("ABC".chars());
    final Stream<String> splitOf
        = Stream.of("A,B,C".split(","));
    //Stream from builder
    final Stream<String> builderPairStream =
        Stream.<String>builder().add("A").build();
    //Stream to Array
    final Pair<String, String>[] toArray =
        generateDemoValues.stream().toArray(Pair[]::new);
    //Stream to List
    final List<Pair> toList =
        generateDemoValues.stream()
                          .collect(Collectors.toList());
    //Stream to Set
    final Set<Pair> toSet =
        generateDemoValues.stream()
                          .collect(Collectors.toSet());
    //Stream to Map
    final Map<String, List<Pair<String,String>>> collectedToMap =
        generateDemoValues
            .stream()
            .collect(Collectors
                         .groupingBy(Pair::getT1));
    System.out.println("collectedToMap.size() = "
                       + collectedToMap.size());

    for (final Map.Entry<String, List<Pair<String, String>>> entry :
        collectedToMap.entrySet()) {
      System.out.println("entry = " + entry);
    }
  }

  private static List<Pair<String,String>> generateDemoValues() {
    return Arrays.asList(
        new Pair<>("A" , "A") ,
        new Pair<>("B" , "B") ,
        new Pair<>("C" , "C")
    );
  }
}
