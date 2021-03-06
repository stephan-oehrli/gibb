package grafikEditor.userInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import grafikEditor.figuren.Dreieck;
import grafikEditor.figuren.Ellipse;
import grafikEditor.figuren.Figur;
import grafikEditor.figuren.Kreis;
import grafikEditor.figuren.Linie;
import grafikEditor.figuren.Rechteck;
import grafikEditor.figuren.Zeichnung;
import grafikEditor.importExport.FigurLoader;

final class EditorControl implements MousePosSubscriber{
	private Zeichnung zeichnung = new Zeichnung();
	private char figurTyp = 'a';
	private Point ersterPunkt;
	private Point primePos;
	private Figur figur;
	private List<FigurTypSubscriber> figurTypSubscribers = new ArrayList<>();

	public void allesNeuZeichnen(Graphics g) {
		zeichnung.zeichneFiguren(g);
	}

	public void setFigurTyp(char figurTyp) {
		this.figurTyp = figurTyp;
		figurTypSubscribers.forEach(subscriber -> subscriber.update(figurTyp));
	}

	public void erzeugeFigurMitErstemPunkt(Point ersterPunkt) {
		this.ersterPunkt = ersterPunkt;
		switch (figurTyp) {
		case 'a':
			figur = zeichnung.selectFigur(ersterPunkt);
			primePos = new Point(figur.getX(), figur.getY());
			break;
		case 'r':
			figur = new Rechteck(ersterPunkt.x, ersterPunkt.y, 0, 0);
			break;
		case 'l':
			figur = new Linie(ersterPunkt.x, ersterPunkt.y, 0, 0);
			break;
		case 'k':
			figur = new Kreis(ersterPunkt.x, ersterPunkt.y, 0);
			break;
		case 'd':
			figur = new Dreieck(ersterPunkt.x, ersterPunkt.y, 0, 0);
			break;
		case 'e':
			figur = new Ellipse(ersterPunkt.x, ersterPunkt.y, 0, 0);
			break;
		}
		
		if (figur != null) {
			figur.setLinienFarbe(Color.RED);
			zeichnung.hinzufuegen(figur);
		}
	}

	public void aktualisiereFigurMitZweitemPunkt(Point zweiterPunkt) {
		if (ersterPunkt != zweiterPunkt && figur != null) {
			int breite = zweiterPunkt.x - ersterPunkt.x;
			int hoehe = zweiterPunkt.y - ersterPunkt.y;
			
			switch (figurTyp) {
			case 'a':
				figur.move(zweiterPunkt.x - (ersterPunkt.x - primePos.x), zweiterPunkt.y - (ersterPunkt.y - primePos.y));
				break;
			case 'r':
				int x = (breite < 0) ? ersterPunkt.x + breite : ersterPunkt.x;
				int y = (hoehe < 0) ? ersterPunkt.y + hoehe : ersterPunkt.y;
				figur.setX(x);
				figur.setY(y);
				((Rechteck)figur).setBreite(Math.abs(breite));
				((Rechteck)figur).setHoehe(Math.abs(hoehe));
				break;
			case 'l':
				((Linie)figur).setEndX(zweiterPunkt.x);
				((Linie)figur).setEndY(zweiterPunkt.y);
				break;
			case 'k':
				int xDifferenz = zweiterPunkt.x - ersterPunkt.x;
				int yDifferenz = zweiterPunkt.y - ersterPunkt.y;
				double radius = Math.sqrt((xDifferenz * xDifferenz)+(yDifferenz * yDifferenz));
				((Kreis)figur).setRadius((int)Math.round(radius));
				break;
			case 'd':
				((Dreieck)figur).setBreite(breite);
				((Dreieck)figur).setHoehe(hoehe);
				break;
			case 'e':
				((Ellipse)figur).setBreite(Math.abs(breite));
				((Ellipse)figur).setHoehe(Math.abs(hoehe));
				break;
			}
		}
	}

	public void saveZeichung() {
		zeichnung.save();
	}

	public void loadZeichnung() {
		FigurLoader loader = new FigurLoader();
		zeichnung = loader.load();
	}
	
	public void addFigurTypSubscriber(FigurTypSubscriber subscriber) {
		figurTypSubscribers.add(subscriber);
	}
	
	public void removeFigurTypSubscriber(FigurTypSubscriber subscriber) {
		figurTypSubscribers.remove(subscriber);
	}

	public void prepareForNextFigur() {
		if (figur != null) figur.setLinienFarbe(Color.BLACK);
		figur = null;
	}

	@Override
	public void update(Point mousePos) {
		if (figurTyp == 'a') {
			zeichnung.hover(mousePos);
		}
		
	}
}
