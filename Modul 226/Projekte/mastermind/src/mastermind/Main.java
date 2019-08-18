package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public final static String INSTRUCTION = "Geben Sie einen Versuchscode mit vier Buchstaben aus der Menge {r,g,b,y,s,w} ein";
	public final static String GAME_END = "Spiel beendet. Geheimcode war xxxx. Anzahl Versuche: 5";

	private static InputStreamReader inputReader = new InputStreamReader(System.in);
	private static BufferedReader reader = new BufferedReader(inputReader);

	public static void main(String[] args) {
		System.out.println(INSTRUCTION);
		System.out.println(GAME_END);
		System.out.println("Geben Sie etwas ein:");
		String userInput = getUserInput();
		System.out.println(userInput);
	}

	public static String getUserInput() {
		String userInput = "";
		try {
			userInput = reader.readLine();
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen der Benutzereingabe.");
		}
		return userInput;
	}

}
