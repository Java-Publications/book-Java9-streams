package org.rapidpm.book.java9.streams.chap_00.v011;

import static java.util.stream.Collectors.counting;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final Long amountA = nextIntegerStream().collect(counting());

    final Long amountB = nextIntegerStream().count();
  }
}
