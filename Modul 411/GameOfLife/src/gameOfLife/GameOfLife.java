package gameOfLife;

import java.io.IOException;
import java.util.Random;

public class GameOfLife {
	private char[][][] world = new char[2][25][25];

	
	public GameOfLife(int livingCellsInPercentage) throws InterruptedException {
		createWorld();
		addRandomCells(livingCellsInPercentage);
		for (int i = 0; i < 100; i++) {
			clearScreen();
			System.out.println();
			Thread.sleep(50);
			printWorld();
			calculateGeneration();
			Thread.sleep(150);
		}
	}

	private void createWorld() {
		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0][0].length; j++) {
				world[0][i][j] = '.';
				world[1][i][j] = '.';
			}
		}
	}

	private void addRandomCells(int livingCellsInPercentage) {
		Random random = new Random();
		int livingCells = world[0][0].length * world[0][0].length / 100 * livingCellsInPercentage; 
		int x, y;
		for (int i = 0; i < livingCells; i++) {
			do {
			y = random.nextInt(world[0].length);
			x = random.nextInt(world[0].length);
			} while (world[0][y][x] == '*');
			world[0][y][x] = '*';
		}
	}

	private void clearScreen() {  
	    try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void printWorld() {
		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0][0].length; j++) {
				System.out.print(world[0][i][j]);
			}
			System.out.println();
		}
	}

	private void calculateGeneration() {
		resetCopyWorld();
		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0].length; j++) {
					applyRuleOnCell(i, j);
			}
		}
		copy();
	}

	private void resetCopyWorld() {
		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0][0].length; j++) {
				world[1][i][j] = '.';
			}
		}
	}

	private void applyRuleOnCell(int x, int y) {
		int livingNeighbourCells = countLivingNeighbourCells(x, y);
		if (world[0][x][y] == '.' && livingNeighbourCells == 3) {
			world[1][x][y] = '*';
		} else if (world[0][x][y] == '*' && (livingNeighbourCells > 3 || livingNeighbourCells < 2)){
				world[1][x][y] = '.';
		} else {
			world[1][x][y] = world[0][x][y];
		}
	}

	private int countLivingNeighbourCells(int x, int y) {
		int counter = 0;
		for (int column = -1; column <= 1; column++) {
			for (int row = -1; row <= 1; row++) {
				if (column != 0 || row != 0) {
					counter += countLivingCell(x + column, y + row);
				}
			}
		}
		return counter;
	}

	private int countLivingCell(int x, int y) {
		if (isInIndex(x,y) && world[0][x][y] == '*') {
			return 1;
		}
		return 0;
	}

	private boolean isInIndex(int x, int y) {
		return (x > 0 && x < world[0].length) && (y > 0 && y < world[0].length);
	}

	private void copy() {
		for (int i = 0; i < world[0].length; i++) {
			for (int j = 0; j < world[0][0].length; j++) {
				world[0][i][j] = world[1][i][j];
			}
		}
	}  
}
