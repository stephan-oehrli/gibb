package grafikEditor.Figuren;

import java.awt.Color;

public class Dreieck extends GeschlosseneFigur {
	private int breite;
	private int hoehe;

	public Dreieck(int x, int y, int breite, int hoehe) {
		this(x, y, breite, hoehe, null, null);
	}
	
	public Dreieck(int x, int y, int breite, int hoehe, Color fuellung) {
		this(x, y, breite, hoehe, fuellung, null);
	}
	
	public Dreieck(int x, int y, int breite, int hoehe, Color fuellung, Color linienFarbe) {
		super(x, y, fuellung, linienFarbe);
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public int[] getXPunkte() {
		return new int[] {x - breite / 2, x, x + breite / 2};
	}
	
	public int[] getYPunkte() {
		return new int[] {y + hoehe / 2, y - hoehe / 2, y + hoehe / 2};
	}
}
