package ch.fhnw.oop2.module05.streams.ab1;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Startwert: die ersten beiden Fibonacci Zahlen
        // Formel: Tuple(x,y) = ( y , x + y) (von letzen Tupel)
        Stream.iterate(new Tuple<Integer>(1,1), t -> new Tuple<>(t.t2, t.t1 + t.t2))
                .limit(30)
                .forEach(System.out::println);
        ;
    }
}
