package org.rapidpm.book.java9.streams.chap_01.v104;

import java.util.stream.Stream;

/**
 *
 */
public class MainB {

  public static void main(String[] args) {

    Stream
        .of("AB" , "AAB" , "AAAB" , "AAAAB" , "AAAAAB")
        .findFirst()
        .ifPresent(System.out::println);

    Stream
        .of("AB" , "AAB" , "AAAB" , "AAAAB" , "AAAAAB")
        .parallel()
        .findFirst()
        .ifPresent(System.out::println);

  }
}
