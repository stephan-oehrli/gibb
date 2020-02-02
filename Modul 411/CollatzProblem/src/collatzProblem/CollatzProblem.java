package collatzProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollatzProblem {
	
	public static void main(String[] args) {
		longest_sequence();
	}
	
	public static void start_procedural_and_funcitional_collatz() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bitte geben Sie eine Zahl ein: ");
		try {
			long number = Long.parseLong(in.readLine());
			System.out.println("Prozedurale Berrechnung:");
			collatz_procedure(number);
			System.out.println("\nFunktionale Berrechnung:");
			collatz_function(number);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void collatz_procedure(long n) {
		while (n > 1) {
			n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
			System.out.print(n + ", ");
		}
	}
	
	public static long collatz_function(long n) {
		if (n > 1) {
			if (n % 2 == 0) {
				System.out.print(n / 2 + ", ");
				return collatz_function(n / 2);
			} else {
				System.out.print(3 * n + 1 + ", ");
				return collatz_function(3 * n + 1);
			}
		}
		return n;
	}
	
	public static void longest_sequence() {
		long maxElements = 0;
		int maxElementsStart = 0;
		for (int i = 1; i <= 1000000; i++) {
			long n = i;
			long elements = 0;
			while (n > 1) {
				n = (n % 2 == 0) ? n / 2 : 3 * n + 1;
				elements++;
			}
			if (elements > maxElements) {
				System.out.println(elements + " Elemente bei " + i + " ...");
				maxElements = elements;
				maxElementsStart = i;
			}
		}
		System.out.println("Die längste Sequenz bei einer Startzahl von < 1000000 ist: " + maxElements + " Elemente mit der Startzahl " + maxElementsStart);
	}
}
