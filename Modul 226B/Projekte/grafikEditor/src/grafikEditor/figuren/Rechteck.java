package grafikEditor.figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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

	@Override
	public void skalieren(float faktor) {
		breite *= faktor;
		hoehe *= faktor;
	}

	@Override
	public void zeichneFigur(Graphics2D g2) {
		if (getDrehungInRad() != 0) {
			g2.rotate(getDrehungInRad(), x, y);
		}
		if (fuellung != null) {
			g2.setColor(fuellung);
			g2.fillRect(x, y, breite, hoehe);
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setStroke(new BasicStroke(linienDicke));
		g2.drawRect(x, y, breite, hoehe);
	}

	@Override
	public String toString() {
		return super.toString() + "," + breite + "," + hoehe + "," + fuellung + "," + linienFarbe;
	}

	@Override
	public boolean isFormTypeOf(String type) {
		return "r".equals(type);
	}
	
	@Override
	public Figur clone(String[] figurArr) {
		x = Integer.parseInt(figurArr[1]);
		y = Integer.parseInt(figurArr[2]);
		breite = Integer.parseInt(figurArr[3]);
		hoehe = Integer.parseInt(figurArr[4]);
		return new Rechteck(x, y, breite, hoehe);
	}
	
}
