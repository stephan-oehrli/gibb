package grafikEditor.Figuren;

import java.awt.Color;

public class Ellipse extends GeschlosseneFigur {
	int breite;
	int hoehe;

	public Ellipse(int x, int y, int breite, int hoehe) {
		this(x, y, breite, hoehe, null, null);
	}
	
	public Ellipse(int x, int y, int breite, int hoehe, Color fuellung) {
		this(x, y, breite, hoehe, fuellung, null);
	}

	public Ellipse(int x, int y, int breite, int hoehe, Color fuellung, Color linienFarbe) {
		super(x, y, fuellung, linienFarbe);
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}
}
