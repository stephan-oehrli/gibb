package grafikEditor.userInterface;

import java.awt.Graphics;
import java.awt.Point;

import grafikEditor.figuren.Rechteck;
import grafikEditor.figuren.Zeichnung;

final class EditorControl {
	private Zeichnung zeichnung = new Zeichnung();
	private char figurTyp;
	private Point ersterPunkt;

	public void allesNeuZeichnen(Graphics g) {
		zeichnung.zeichneFiguren(g);
	}

	public void setFigurTyp(char figurTyp) {
		this.figurTyp = figurTyp;
	}

	public void setErsterPunkt(Point ersterPunkt) {
		this.ersterPunkt = ersterPunkt;
	}

	public void erzeugeFigurMitZweitemPunkt(Point zweiterPunkt) {
		if (ersterPunkt != zweiterPunkt) {
			Rechteck rechteck = new Rechteck(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x - ersterPunkt.x,
					zweiterPunkt.y - ersterPunkt.y);
			zeichnung.hinzufuegen(rechteck);
		}
	}
}
