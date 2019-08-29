package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

	private static String[] secretCode;
	private static int numberOfAttempts;

	public static void main(String[] args) {
		secretCode = generateSecretCode();
		displayInstructions();
		String[] userCode = getUserCode();
		while (!isCodeCorrect(userCode)) {
			displayInstructions();
			userCode = getUserCode();
		}
		displayGameOverMessage();
	}

	private static String[] generateSecretCode() {
		Random random = new Random();
		ArrayList<String> colors = new ArrayList<>(Arrays.asList("r", "g", "b", "y", "s", "w"));
		int codeLength = 4;
		String[] secretCode = new String[codeLength];
		for (int i = 0; i < codeLength; i++) {
			secretCode[i] = colors.remove(random.nextInt(colors.size()));
		}
		return secretCode;
	}

	private static void displayInstructions() {
		System.out.println("Geben Sie einen Versuchscode mit vier Buchstaben aus der Menge {r,g,b,y,s,w} ein: ");
	}

	private static String[] getUserCode() {
		String userInput = readUserInput();
		while (!isInputValid(userInput)) {
			System.out.println(
					"Falsche Eingabe.\nDer Code darf nur je einen der 4 Buchstaben aus der Menge {r,g,b,y,s,w} enthalten.\nVersuchen Sie es erneut: ");
			userInput = readUserInput();
		}
		numberOfAttempts++;
		return userInput.toLowerCase().split("");
	}

	private static String readUserInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = "";
		try {
			userInput = reader.readLine();
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Benutzereingabe.");
		}
		return userInput;
	}

	private static boolean isInputValid(String input) {
		ArrayList<String> colors = new ArrayList<>(Arrays.asList("r", "g", "b", "y", "s", "w"));
		if (input.length() != 4) {
			return false;
		}
		String[] splittedInput = input.toLowerCase().split("");
		for (String letter : splittedInput) {
			if (colors.contains(letter)) {
				colors.remove(letter);
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean isCodeCorrect(String[] userCode) {
		List<String> secretCodeArray = Arrays.asList(secretCode);
		int correctColors = 0;
		int correctPositions = 0;
		for (int i = 0; i < userCode.length; i++) {
			if (secretCodeArray.contains(userCode[i])) {
				correctColors++;
				if (secretCodeArray.get(i).equals(userCode[i])) {
					correctPositions++;
				}
			}
		}
		if (correctColors == userCode.length && correctPositions == userCode.length) {
			return true;
		} else {
			System.out.println(
					"Anzahl korrekte Farben: " + correctColors + "\nAnzahl korrekte Positionen: " + correctPositions);
			return false;
		}
	}

	private static void displayGameOverMessage() {
		System.out.println("Gratulation! Sie haben es geschafft.");
		System.out.println("Spiel beendet. Geheimcode war " + String.join("", secretCode) + ". Anzahl Versuche: "
				+ numberOfAttempts);
	}

}
