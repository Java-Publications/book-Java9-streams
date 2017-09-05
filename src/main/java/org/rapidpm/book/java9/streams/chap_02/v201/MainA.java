package org.rapidpm.book.java9.streams.chap_02.v201;

import static java.lang.System.out;
import static java.util.Arrays.asList;

import java.util.Spliterator;
import java.util.Spliterators;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {

    final Spliterator<String> spliterator = Spliterators
        .spliterator(
            asList("1" , "2" , "3") ,
            Spliterator.NONNULL);

    out.println("spliterator.getExactSizeIfKnown() = " + spliterator.getExactSizeIfKnown());
    out.println("spliterator.estimateSize() = " + spliterator.estimateSize());

  }
}
