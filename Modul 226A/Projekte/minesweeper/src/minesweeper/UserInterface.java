package minesweeper;

import java.util.Scanner;

public class UserInterface {
	private Playground playground;

	public UserInterface(Playground playground) {
		this.playground = playground;
	}

	public void displayInstructions() {
		displayInstructions(true);
	}

	private void displayInstructions(boolean includingPlayground) {
		if (includingPlayground) System.out.print(playground);
		System.out.println("" +
				"\nGeben Sie ein Kommando ein: \n" +
				"T x y (z.B. T 2 3 deckt die Zelle bei Spalte 2 Reihe 3 auf) \n" +
				"M x y (z.B. M 6 1 markiert die Zelle bei Spalte 6 Reihe 1) \n");
	}

	public void manageUserInput() {
		String[] userInput = getValidUserInput();
		playground.executeCommand(userInput);
	}

	@SuppressWarnings("resource")
	private String[] getValidUserInput() {
		Scanner scanner = new Scanner(System.in);
		String userInput;
		boolean valid;
		do {
			userInput = scanner.nextLine();
			valid = Validator.inputIsValid(userInput);
			if (!valid) {
				System.out.println("Keine g�ltige Eingabe.");
				displayInstructions(false);
			}
		} while (!valid);
		return userInput.toLowerCase().replace(" ", "").split("");
	}

	public void displayGameOverMessage() {
		playground.reveal();
		System.out.print(playground);
		System.out.println(Referee.gameLost
				? "\nGame Over!\nMine ist explodiert!"
				: "\nGewonnen!\nGratulation! Sie haben alle Minen entsch�rft.");
	}
}
