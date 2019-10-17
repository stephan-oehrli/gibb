package minesweeper;

public class Main {

	public static void main(String[] args) {

		Playground playground = new Playground(5, 6, 5);
		UserInterface ui = new UserInterface(playground);

		while (!ui.isGameOver()) {
			ui.displayInstructions();
			ui.manageUserInput();
		}
	}
}
