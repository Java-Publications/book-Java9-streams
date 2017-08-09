package org.rapidpm.book.java9.streams.v005;

import static java.util.stream.Collectors.reducing;
import static org.rapidpm.book.java9.streams.utils.DemoData.nextIntegerStream;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 *
 */
public class MainC {
  public static void main(String[] args) {
    final Integer resultA = nextIntegerStream()
        .collect(reducing(
            0 ,
            new Function<Integer, Integer>() {
              @Override
              public Integer apply(Integer input) {
                return Math.round(10 / input);
              }
            } ,
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
            input -> Math.round(10 / input) ,
            (a , b) -> a + b
        ));
    System.out.println("resultB = " + resultB);

    final Integer resultC = nextIntegerStream()
        .reduce(0 ,
                new BiFunction<Integer, Integer, Integer>() {
                  @Override
                  public Integer apply(Integer old , Integer next) {
                    return old + Math.round(10 / next);
                  }
                } ,
                (a , b) -> a + b
        );
    System.out.println("resultC = " + resultC);

    final Integer resultD = nextIntegerStream()
        .reduce(0 ,
                (old , next) -> old + Math.round(10 / next) ,
                (a , b) -> a + b
        );
    System.out.println("resultD = " + resultD);
  }
}
