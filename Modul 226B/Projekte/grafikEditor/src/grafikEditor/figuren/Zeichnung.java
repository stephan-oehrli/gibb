package grafikEditor.figuren;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import grafikEditor.importExport.FigurSaver;

public class Zeichnung {
	private List<Figur> zeichnungen = new ArrayList<>();

	public Zeichnung() {
		super();
	}

	/**
	 * Zeichnet alle Figuren.
	 * 
	 * @param g Referenz auf das Graphics-Objekt zum zeichnen.
	 */
	public void zeichneFiguren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		for (Figur f : zeichnungen) {
			f.zeichneFigur(g2);
			g2.setTransform(old);
		}
	}

	/**
	 * Fügt eine weitere Figur hinzu und löst die Auffrischung des Fensterinhaltes
	 * aus.
	 * 
	 * @param figur Referenz auf das weitere Figur-Objekt.
	 */
	public void hinzufuegen(Figur figur) {
		zeichnungen.add(figur);
	}

	/**
	 * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
	 */
	public void allesLoeschen() {
		zeichnungen.clear();
	}
	
	public void save() {
		FigurSaver saver = new FigurSaver();
		saver.save(zeichnungen);
	}
}
