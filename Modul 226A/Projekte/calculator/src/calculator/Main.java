package calculator;

public class Main {

	public static void main(String[] args) {
		testCalculator();
	}

	private static void testCalculator() {
		try {
			for (int i = 1; i <= 6; i++) {
				System.out.println(calc(4, 2, i));
			}
		} catch (IllegalStateException e) {
			System.err.println(e.getMessage());
		}
	}

	public static int calc(int operand1, int operand2, int operator) throws IllegalStateException {
		switch (operator) {
		case 1:
			return operand1 + operand2;
		case 2:
			return operand1 - operand2;
		case 3:
			return operand1 * operand2;
		case 4:
			return operand1 / operand2;
		case 5:
			return operand1 % operand2;
		default:
			throw new IllegalStateException("Ungültiger Operator");
		}
	}
}
