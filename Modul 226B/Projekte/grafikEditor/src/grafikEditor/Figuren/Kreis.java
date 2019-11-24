package grafikEditor.Figuren;

import java.awt.Color;

public class Kreis extends GeschlosseneFigur {
	private int radius;
	
	public Kreis(int x, int y, int radius) {
		this(x, y, radius, null, null);
	}
	
	public Kreis(int x, int y, int radius, Color fuellung) {
		this(x, y, radius, fuellung, null);
	}
	
	public Kreis(int x, int y, int radius, Color fuellung, Color linienFarbe) {
		super(x, y, fuellung, linienFarbe);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public void skalieren(float faktor) {
		radius *= faktor;
	}
}
