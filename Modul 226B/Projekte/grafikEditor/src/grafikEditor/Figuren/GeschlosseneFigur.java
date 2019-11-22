package grafikEditor.Figuren;

import java.awt.Color;

public abstract class GeschlosseneFigur extends Figur {
	protected Color fuellung;
		
	public GeschlosseneFigur(int x, int y, Color fuellung, Color linienFarbe) {
		super(x, y, linienFarbe);
		this.fuellung = fuellung;
	}

	public Color getFuellung() {
		return fuellung;
	}

	public void setFuellung(Color fuellung) {
		this.fuellung = fuellung;
	}
}
