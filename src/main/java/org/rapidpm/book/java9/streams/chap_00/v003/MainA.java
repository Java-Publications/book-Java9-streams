package org.rapidpm.book.java9.streams.chap_00.v003;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.book.java9.streams.utils.DemoData;
import org.rapidpm.frp.model.Pair;

/**
 *
 */
public class MainA {

  public static Stream<Pair<String,String>> nextStream(){
    return DemoData.nextStreamWithDuplicates();
  }


  public static void main(String[] args) {
    final Map<String, String> mapA = nextStream()
        .collect(Collectors.toMap(new Function<Pair<String, String>, String>() {
          @Override
          public String apply(Pair<String, String> p) {
            return p.getT1();
          }
        } , new Function<Pair<String, String>, String>() {
          @Override
          public String apply(Pair<String, String> p) {
            return p.getT2().toLowerCase();
          }
        }));
    System.out.println("mapA = " + mapA);

    final Map<String, String> mapB = nextStream()
        .collect(Collectors.toMap(Pair::getT1 , p -> p.getT2().toLowerCase()));

    System.out.println("mapB = " + mapB);




  }
}
