package ch.fhnw.oop2.module05.streams;

import java.util.stream.Stream;

public class OptimzedWalks {

	public static void main(String[] args) {
		
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
			.filter(n -> { 
				System.out.println("filtering: " + n); 
				return n % 2 == 0; }) // nur gerade Zahlen
			.map(n -> { 
				System.out.println("mapping: " + n); 
				return n * n; }) // map = für jedes Element im Stream etwas machen: quadrieren!
			.limit(3) // resultat: limitieren
			.forEach(System.out::println);

			// wichtig: Durchlaufen = Wenn er im Filter etwas findet, welches der Prädikat erfüllt, läuft er einmal durch die ganze Kette!
	}
}


