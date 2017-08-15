package org.rapidpm.book.java9.streams.chap_00.v005;

import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 *
 */
public class MainA {


  public static void main(String[] args) {

    final Optional<Integer> resultA = nextIntegerStream()
        .collect(Collectors.reducing(new BinaryOperator<Integer>() {
          @Override
          public Integer apply(Integer a , Integer b) {
            return a + b;
          }
        }));

    System.out.println("resultA = " + resultA);

    final Optional<Integer> resultB = nextIntegerStream()
        .collect(Collectors.reducing((a , b) -> a + b));
    System.out.println("resultB = " + resultB);

    final Optional<Integer> resultC = nextIntegerStream()
        .reduce((a , b) -> a + b);
    System.out.println("resultC = " + resultC);



  }

}
