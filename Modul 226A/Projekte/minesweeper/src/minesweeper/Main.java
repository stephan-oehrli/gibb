package minesweeper;

public class Main {

	public static void main(String[] args) {

		Playground playground = new Playground(10, 10, 15);
		UserInterface ui = new UserInterface(playground);

		while (!Referee.isGameOver()) {
			ui.displayInstructions();
			ui.manageUserInput();
		}
		ui.displayGameOverMessage();
	}
}
