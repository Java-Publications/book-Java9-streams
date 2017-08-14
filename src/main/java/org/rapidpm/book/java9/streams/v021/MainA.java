package org.rapidpm.book.java9.streams.v021;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 */
public class MainA {

  public static void main(String[] args) {
    final Path p = Paths.get(System.getProperty("java.home"), "COPYRIGHT");
    try(Stream<String> stream= Files.lines(p, StandardCharsets.ISO_8859_1)) {
      System.out.println(stream.filter(s->s.contains("Oracle")).count());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
