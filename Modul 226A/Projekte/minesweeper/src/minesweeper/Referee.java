package minesweeper;

public class Referee {

	public static boolean gameLost = false;
	public static boolean gameWon = false;

	public static boolean isGameOver() {
		return gameLost || gameWon;
	}

	public static void checkForWin(Cell[][] cells, int numOfBombs) {
		int markedCellsWithBombs = 0;
		for (Cell[] yCells : cells) {
			for (Cell cell : yCells) {
				if (cell.hasCorrectMark())
					markedCellsWithBombs++;
			}
		}
		gameWon = markedCellsWithBombs == numOfBombs;
	}

	public static void checkForLost(Cell cell) {
		gameLost = cell.isExploded();
	}
}
