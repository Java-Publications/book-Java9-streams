package org.rapidpm.book.java9.streams.v019;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static org.rapidpm.book.java9.streams.v019.MainA.Brand.BMW;
import static org.rapidpm.book.java9.streams.v019.MainA.Colour.GREEN;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.rapidpm.frp.model.Quad;

/**
 *
 */
public class MainA {

  public enum Brand {BMW, VW, PORSCHE, FIAT}

  public enum Colour {RED, GREEN, WHITE, BLACK}

  public static class Car extends Quad<Brand, Colour, Integer, Boolean> {
    public Car(Brand brand , Colour colour , Integer km , Boolean modified) {
      super(brand , colour , km , modified);
    }

    public Brand brand() {return getT1();}

    public Colour colour() {return getT2();}

    public Integer km() {return getT3();}

    public Boolean modified() {return getT4();}
  }

  public static Stream<Car> randomCars(int amount) {
    final Random random = new Random();
    return IntStream
        .range(0 , amount)
        .mapToObj((i) -> new Car(
            Brand.values()[random.nextInt(4)] ,
            Colour.values()[random.nextInt(4)] ,
            random.nextInt(100_000) ,
            random.nextBoolean()
        ));
  }

  public static void main(String[] args) {

    final Map<Brand, Map<Colour, List<Car>>> resultA = randomCars(100)
        .collect(
            groupingBy(Car::brand ,
                       groupingBy(Car::colour)));

    resultA.getOrDefault(BMW , emptyMap())
           .getOrDefault(GREEN , emptyList())
           .forEach(System.out::println);

    final Map<Brand, Map<Colour, Double>> resultB = randomCars(100)
        .collect(filtering(Car::modified ,
                           groupingBy(Car::brand ,
                                      groupingBy(Car::colour ,
                                                 averagingDouble(Car::km)))));


    resultB.getOrDefault(BMW , emptyMap())
           .forEach((colour , km) -> System.out.println("colour / avg [km] = " + colour + " - " + km));

  }
}
