package org.rapidpm.book.java9.streams.v005;

import static java.util.stream.Collectors.reducing;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 *
 */
public class MainB {


  public static void main(String[] args) {
    final Integer resultA = nextIntegerStream()
        .collect(reducing(
            0 ,
            new BinaryOperator<Integer>() {
              @Override
              public Integer apply(Integer a , Integer b) {
                return a + b;
              }
            }
        ));
    System.out.println("resultA = " + resultA);


    final Integer resultB = nextIntegerStream()
        .collect(reducing(
            0 ,
            (a , b) -> a + b
        ));
    System.out.println("resultB = " + resultB);

    final Integer resultC = nextIntegerStream()
        .reduce(0 , (a , b) -> a + b);
    System.out.println("resultC = " + resultC);



  }
}
