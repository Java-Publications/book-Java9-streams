package org.rapidpm.book.java9.streams.v010;

import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import org.rapidpm.book.java9.streams.utils.DemoData;

/**
 *
 */
public class MainA {
  public static void main(String[] args) {
    final Double sumA = DemoData.nextIntegerStream().collect(Collectors.summingDouble(new ToDoubleFunction<Integer>() {
      @Override
      public double applyAsDouble(Integer v) {
        return v;
      }
    }));
    System.out.println("sumA = " + sumA);

   final Double sumB = DemoData.nextIntegerStream().collect(Collectors.summingDouble(v -> v));
    System.out.println("sumB = " + sumB);

   final Double sumC = DemoData.nextIntegerStream().mapToDouble(v -> v).sum();
    System.out.println("sumC = " + sumC);


  }
}
