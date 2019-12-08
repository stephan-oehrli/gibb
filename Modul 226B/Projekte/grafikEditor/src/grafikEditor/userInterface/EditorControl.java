package grafikEditor.userInterface;

import java.awt.Graphics;
import java.awt.Point;

import grafikEditor.figuren.Figur;
import grafikEditor.figuren.Kreis;
import grafikEditor.figuren.Linie;
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
			Figur figur = null;
			
			switch (figurTyp) {
			case 'r':
				int breite = zweiterPunkt.x - ersterPunkt.x;
				int hoehe = zweiterPunkt.y - ersterPunkt.y;
				int x = (breite < 0) ? ersterPunkt.x + breite : ersterPunkt.x;
				int y = (hoehe < 0) ? ersterPunkt.y + hoehe : ersterPunkt.y;
				figur = new Rechteck(x, y, Math.abs(breite), Math.abs(hoehe));
				break;
			case 'l':
				figur = new Linie(ersterPunkt.x, ersterPunkt.y, zweiterPunkt.x, zweiterPunkt.y);
				break;
			case 'k':
				int xVerschiebung = zweiterPunkt.x - ersterPunkt.x;
				int yVerschiebung = zweiterPunkt.y - ersterPunkt.y;
				double radius = Math.sqrt((xVerschiebung * xVerschiebung)+(yVerschiebung * yVerschiebung));
				figur = new Kreis(ersterPunkt.x, ersterPunkt.y, (int) Math.round(radius));
				break;
			}
			
			if (figur != null) {
				zeichnung.hinzufuegen(figur);
			}
		}
	}
}
