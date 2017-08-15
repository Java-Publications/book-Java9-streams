package org.rapidpm.book.java9.streams.chap_00.v020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {


    //Type of the elements that will be collected
    //Type of the internal datastructure that will be used during collecting
    //final output Type

    final Collector<String, List<String>, Set<String>> collectorA
        = Collector.<String, List<String>, Set<String>>of(
        (Supplier<List<String>>) () -> new ArrayList<>() ,
        (BiConsumer<List<String>, String>) (list , o) -> list.add(o) ,
        (BinaryOperator<List<String>>) (listA , listB) -> {
          listA.addAll(listB);
          return listA;
        } ,
        (Function<List<String>, Set<String>>) list -> {
          Set<String> set = new HashSet<>();
          set.addAll(list);
          return set;
        } ,
        Collector.Characteristics.UNORDERED
    );

    final Set<String> resultA = Stream.of("Hello" , "Collector").collect(collectorA);

    final Collector<String, List<String>, Set<String>> collectorB
        = Collector.of(
        ArrayList::new ,
        List::add ,
        (listA , listB) -> { listA.addAll(listB); return listA; } ,
        list -> {
          Set<String> set = new HashSet<>();
          set.addAll(list);
          return set;
        } ,
        Collector.Characteristics.UNORDERED
    );




    final Collector<String, List<String>, List<String>> collectorC = Collector.of(
        () -> new ArrayList<>() ,
        (list , value) -> list.add(value) ,
        (listA , listB) -> {
          listA.addAll(listB);
          return listA;
        } ,
        Collector.Characteristics.UNORDERED);




  }


}
