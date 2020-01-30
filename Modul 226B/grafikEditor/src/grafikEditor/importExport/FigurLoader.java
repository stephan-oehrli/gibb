package grafikEditor.importExport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import grafikEditor.figuren.Dreieck;
import grafikEditor.figuren.Ellipse;
import grafikEditor.figuren.Figur;
import grafikEditor.figuren.Kreis;
import grafikEditor.figuren.Linie;
import grafikEditor.figuren.Rechteck;
import grafikEditor.figuren.Text;
import grafikEditor.figuren.Zeichnung;

public class FigurLoader {

	private List<Figur> protoTypes = new ArrayList<>();
	private Zeichnung zeichnung = new Zeichnung();
	
	public FigurLoader() {
		createPrototypes();
	}

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
		for (Figur figur : protoTypes) {
			if (figur.isFormTypeOf(figurArr[0])) {
				zeichnung.hinzufuegen(figur.clone(figurArr));
			}
		}
	}
	
	private void createPrototypes() {
		Rechteck rechteck = new Rechteck(0, 0, 0, 0);
		protoTypes.add(rechteck);
		Kreis kreis = new Kreis(0, 0, 0);
		protoTypes.add(kreis);
		Linie linie = new Linie(0, 0, 0, 0);
		protoTypes.add(linie);
		Dreieck dreieck = new Dreieck(0, 0, 0, 0);
		protoTypes.add(dreieck);
		Ellipse ellipse = new Ellipse(0, 0, 0, 0);
		protoTypes.add(ellipse);
		Text text = new Text(0, 0, null);
		protoTypes.add(text);
	}
}
