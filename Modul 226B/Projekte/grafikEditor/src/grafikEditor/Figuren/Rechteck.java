package grafikEditor.Figuren;

import java.awt.Color;

public class Rechteck extends GeschlosseneFigur {
	private int breite;
	private int hoehe;
	
	public Rechteck(int x, int y, int breite, int hoehe) {
		this(x, y, breite, hoehe, null, null);
	}
	
	public Rechteck(int x, int y, int breite, int hoehe, Color fuellung) {
		this(x, y, breite, hoehe, fuellung, null);
	}
	
	public Rechteck(int x, int y, int breite, int hoehe, Color fuellung, Color linienFarbe) {
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
