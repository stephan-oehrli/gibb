package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
	
	private static String[] secretCode;
	private static int numberOfAttempts;
	
	public static void main(String[] args) {
		secretCode = generateSecretCode();
		displayInstructions();
		displayGameOverMessage();
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
		System.out.println("Geben Sie einen Versuchscode mit vier Buchstaben aus der Menge {r,g,b,y,s,w} ein");
	}

	private static void displayGameOverMessage() {
		System.out.println("Spiel beendet. Geheimcode war " + String.join(",", secretCode) + ". Anzahl Versuche: " + numberOfAttempts);
	}
}
