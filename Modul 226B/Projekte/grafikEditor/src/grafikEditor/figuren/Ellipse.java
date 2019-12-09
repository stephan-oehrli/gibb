package grafikEditor.figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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
			g2.fillArc(x - breite, y - hoehe, breite, hoehe, 0, 360);
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setStroke(new BasicStroke(linienDicke));
		g2.drawArc(x - breite, y - hoehe, breite * 2, hoehe * 2, 0, 360);
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + breite + "," + hoehe + "," + fuellung + "," + linienFarbe;
	}

	@Override
	public boolean isFormTypeOf(String type) {
		return "e".equals(type);
	}
	
	@Override
	public Figur clone(String[] figurArr) {
		x = Integer.parseInt(figurArr[1]);
		y = Integer.parseInt(figurArr[2]);
		breite = Integer.parseInt(figurArr[3]);
		hoehe = Integer.parseInt(figurArr[4]);
		return new Ellipse(x, y, breite, hoehe);
	}
}
