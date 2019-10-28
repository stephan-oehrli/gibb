package minesweeper;

public class Validator {

	private static int numOfRows, numOfColumns;

	public static void initValidator(int numOfRows, int numOfColumns) {
		Validator.numOfRows = numOfRows;
		Validator.numOfColumns = numOfColumns;
	}

	public static boolean inputIsValid(String input) {
		String regexPattern = "^[tm][0-" + (numOfColumns - 1) + "][0-" + (numOfRows - 1) + "]$";
		String trimmedInput = input.toLowerCase().replace(" ", "");
		return trimmedInput.matches(regexPattern);
	}
	
	public static boolean cellExists(int y, int x) {
		return ((y >= 0 && y < numOfRows) && (x >= 0 && x < numOfColumns));
	}

	public static boolean cellCanBeTurned(Cell cell) {
		return !cell.isMarked() && !cell.isRevealed();
	}

	public static boolean cellCanBeMarked(Cell cell) {
		return !cell.isRevealed();
	}
}
