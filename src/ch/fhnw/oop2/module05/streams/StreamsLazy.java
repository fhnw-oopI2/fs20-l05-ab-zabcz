package ch.fhnw.oop2.module05.streams;

import java.util.stream.Stream;

public class StreamsLazy {
    public static void main(String[] args) {

        Stream.iterate(1, n -> n + 1)
                .limit(20)
                .peek(n -> System.out.println("Debug: " +n))
                .forEach(System.out::println);
    }
}
