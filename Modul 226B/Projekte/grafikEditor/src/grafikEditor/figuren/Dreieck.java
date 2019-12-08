package grafikEditor.figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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
		return new int[] { x - breite / 2, x, x + breite / 2 };
	}

	public int[] getYPunkte() {
		return new int[] { y + hoehe / 2, y - hoehe / 2, y + hoehe / 2 };
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
			g2.fillPolygon(getXPunkte(), getYPunkte(), 3);
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setStroke(new BasicStroke(linienDicke));
		g2.drawPolygon(getXPunkte(), getYPunkte(), 3);
	}
}
