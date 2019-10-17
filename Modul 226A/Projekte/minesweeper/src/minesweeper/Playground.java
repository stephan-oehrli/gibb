package minesweeper;

import java.util.Random;

public class Playground {

	private int numOfRows, numOfColumns, numOfBombs;
	private boolean gameWon = false;
	private boolean gameLost = false;
	private Cell[][] cells;

	public Playground(int numOfRows, int numOfColumns, int numOfBombs) {
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		this.numOfBombs = numOfBombs;
		Validator.initValidator(numOfRows, numOfColumns);
		buildPlayground();
		plantBombs();
		initCellValues();
	}

	private void initCellValues() {
		for (int y = 0; y < numOfRows; y++) {
			for (int x = 0; x < numOfColumns; x++) {
				Cell cell = cells[y][x];
				if (!cell.hasBomb()) {
					cell.setNumOfNeighbourBombs(countNeighbourBombs(x, y));
				}
			}
		}
	}

	private int countNeighbourBombs(int x, int y) {
		int counter = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (cellExists(y + i, x + j) && cells[y + i][x + j].hasBomb())
					counter++;
			}
		}
		return counter;
	}

	private void turnNeighbourCells(int x, int y) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (cellExists(y + i, x + j) && cells[y + i][x + j].getState() == State.HIDDEN)
					executeCommand(new String[] { "t", String.valueOf(x + j), String.valueOf(y + i) });
			}
		}
	}

	private boolean cellExists(int y, int x) {
		return ((y >= 0 && y < numOfRows) && (x >= 0 && x < numOfColumns));
	}

	private void buildPlayground() {
		cells = new Cell[numOfRows][numOfColumns];
		for (int y = 0; y < numOfRows; y++) {
			for (int x = 0; x < numOfColumns; x++) {
				cells[y][x] = new Cell();
			}
		}
	}

	private void plantBombs() {
		int randomRow, randomColumn;
		Cell randomCell;
		Random random = new Random();
		for (int i = 0; i < numOfBombs; i++) {
			do {
				randomRow = random.nextInt(numOfRows);
				randomColumn = random.nextInt(numOfColumns);
				randomCell = cells[randomRow][randomColumn];
			} while (randomCell.hasBomb());
			randomCell.setHasBomb(true);
		}
	}

	public void displayPlayground() {
		StringBuilder firstLine = new StringBuilder("  ");
		for (int i = 0; i < numOfColumns; i++) {
			firstLine.append(i).append(" ");
		}
		System.out.println(firstLine);
		for (int y = 0; y < numOfRows; y++) {
			StringBuilder line = new StringBuilder(y + " ");
			for (int x = 0; x < numOfColumns; x++) {
				Cell cell = cells[y][x];
				line.append(cell.getDisplayedIcon()).append(" ");
			}
			System.out.println(line);
		}
	}

	public void executeCommand(String[] command) {
		int x = Integer.parseInt(command[1]);
		int y = Integer.parseInt(command[2]);
		Cell cell = cells[y][x];
		if (command[0].equals("t")) {
			cell.turn();
			gameLost = cell.getState() == State.EXPLODED;
			if (!gameLost && cell.getNumOfNeighbourBombs() == 0)
				turnNeighbourCells(x, y);
		} else {
			cell.mark();
			checkForWin();
		}
	}

	private void checkForWin() {
		int markedCellsWithBombs = 0;
		for (Cell[] yCells : cells) {
			for (Cell cell : yCells) {
				if (cell.hasCorrectMark())
					markedCellsWithBombs++;
			}
		}
		gameWon = markedCellsWithBombs == numOfBombs;
	}

	public boolean isGameLost() {
		return gameLost;
	}

	public boolean isGameWon() {
		return gameWon;
	}
}
