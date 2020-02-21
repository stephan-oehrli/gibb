package recursion;

import java.util.Scanner;

/**
 * This program computes Fibonacci numbers using a recursive method.
 */
public class Fibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			long f = fib(i);
			System.out.println("fib(" + i + ") = " + f);
		}
	}

	/**
	 * Computes a Fibonacci number.
	 * 
	 * @param n an integer
	 * @return the nth Fibonacci number
	 */
	public static long recursiveFib(int n) {
		if (n <= 2) {
			return 1;
		} else
			return recursiveFib(n - 1) + recursiveFib(n - 2);
	}
	
	public static long fib(int n) {
		if (n <= 2) return 1;
		long num1 = 1;
		long num2 = 1;
		long sum = 2;
		for (int i = 3; i <= n; i++) {
			sum = num1 + num2;
			if (i % 2 == 0) {
				num2 = sum;
			} else {
				num1 = sum;
			}
		}
		return sum;
	}
}
