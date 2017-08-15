package org.rapidpm.book.java9.streams.chap_01.v104;

import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {
    final Optional<String> first = Stream
        .of("AB" , "AAB" , "AAAB" , "AAAAB" , "AAAAAB")
        .findFirst();
  }

}
