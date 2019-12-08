package grafikEditor.importExport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import grafikEditor.figuren.Dreieck;
import grafikEditor.figuren.Ellipse;
import grafikEditor.figuren.Kreis;
import grafikEditor.figuren.Linie;
import grafikEditor.figuren.Rechteck;
import grafikEditor.figuren.Zeichnung;

public class FigurLoader {

	Zeichnung zeichnung = new Zeichnung();

	public Zeichnung load() {
		try (FileReader reader = new FileReader("figuren.txt")) {
			BufferedReader br = new BufferedReader(reader);
			br.lines().forEach(this::erstelleFigur);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return zeichnung;
	}

	private void erstelleFigur(String string) {
		String[] figurArr = string.split(",");
		switch (figurArr[0]) {
		case "r":
			zeichnung.hinzufuegen(new Rechteck(
					Integer.parseInt(figurArr[1]),
					Integer.parseInt(figurArr[2]),
					Integer.parseInt(figurArr[3]),
					Integer.parseInt(figurArr[4])));
			break;
		case "k":
			zeichnung.hinzufuegen(new Kreis(
					Integer.parseInt(figurArr[1]),
					Integer.parseInt(figurArr[2]),
					Integer.parseInt(figurArr[3])));
			break;
		case "l":
			zeichnung.hinzufuegen(new Linie(
					Integer.parseInt(figurArr[1]),
					Integer.parseInt(figurArr[2]),
					Integer.parseInt(figurArr[3]),
					Integer.parseInt(figurArr[4])
					));
			break;
		case "d":
			zeichnung.hinzufuegen(new Dreieck(
					Integer.parseInt(figurArr[1]),
					Integer.parseInt(figurArr[2]),
					Integer.parseInt(figurArr[3]),
					Integer.parseInt(figurArr[4])
					));
			break;
		case "e":
			zeichnung.hinzufuegen(new Ellipse(
					Integer.parseInt(figurArr[1]),
					Integer.parseInt(figurArr[2]),
					Integer.parseInt(figurArr[3]),
					Integer.parseInt(figurArr[4])
					));
			break;
		}
	}
}
