package minesweeper;

import minesweeper.playground.Playground;

public class Main {

	public static void main(String[] args) {

		Playground playground = new Playground(5, 5, 4);
		UserInterface ui = new UserInterface(playground);

		while (!Referee.isGameOver()) {
			ui.displayInstructions();
			ui.manageUserInput();
		}
		ui.displayGameOverMessage();
	}
}
