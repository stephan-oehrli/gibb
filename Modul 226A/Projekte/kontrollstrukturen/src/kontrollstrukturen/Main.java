package kontrollstrukturen;

import java.util.Random;

public class Main {
	private static Random random = new Random();

	public static void main(String[] args) {
		printTriangle(8);
		System.out.println(greatestCommonDivisor(20, 15));
		printRandomLines(10);
	}
	
	private static void printTriangle(int height) {
		for (int i = 1; i <= height; i++) {
			StringBuilder line = new StringBuilder();
			for (int j = 0; j < i; j++) {
				line.append("*");
			}
			System.out.println(line);
		}
	}
	
	private static int greatestCommonDivisor(int p, int q) {
		if (p < q) {
			int cache = p;
			p = q;
			q = cache;
		}
		while (q != 0) {
			int remaining = p % q;
			p = q;
			q = remaining;
		}
		return p;
	}
	
	private static void printRandomLines(int times) {
		for (int i = 0; i < times; i++) {
			System.out.println("Zeile " + (i + 1) + ": " + getRandomLine());
		}
	}
	
	private static String getRandomLine() {
		int randomInt = random.nextInt(4) + 1;
		StringBuilder line = new StringBuilder("Zufallszahl: " + randomInt + " ");
		int numberOfOsBetween = 10 / randomInt - 1;
		for (int i = 0; i < randomInt; i++) {
			line.append("X");
			for (int j = 0; j < numberOfOsBetween; j++) {
				line.append("O");
			}
		}
		for (int i = 0; i < 10 - (randomInt * (numberOfOsBetween + 1)); i++) {
			line.append("O");
		}
		return line.toString();
	}
}
