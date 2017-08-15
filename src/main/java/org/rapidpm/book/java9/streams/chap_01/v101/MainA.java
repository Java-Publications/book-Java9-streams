package org.rapidpm.book.java9.streams.chap_01.v101;

import java.util.List;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {

    final List<Integer> list = List.of(1 , 2 , 3 , 4);
    for (Integer integer : list) {
      System.out.println("integer = " + integer);
    }

    list.stream().forEach((Integer integer) -> {System.out.println(integer);});
    list.stream().forEach(integer -> {System.out.println(integer);});
    list.stream().forEach(integer -> System.out.println(integer));
    list.stream().forEach(System.out::println);

    list.parallelStream().forEach((Integer integer) -> {System.out.println(integer);});
    list.parallelStream().forEach(integer -> {System.out.println(integer);});
    list.parallelStream().forEach(integer -> System.out.println(integer));
    list.parallelStream().forEach(System.out::println);

    list.forEach((Integer integer) -> {System.out.println(integer);});
    list.forEach(integer -> {System.out.println(integer);});
    list.forEach(integer -> System.out.println(integer));
    list.forEach(System.out::println);
  }
}
