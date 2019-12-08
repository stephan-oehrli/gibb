package grafikEditor.figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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

	@Override
	public void skalieren(float faktor) {
		radius *= faktor;
	}

	@Override
	public void zeichneFigur(Graphics2D g2) {
		if (fuellung != null) {
			g2.setColor(fuellung);
			g2.fillArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360);
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setStroke(new BasicStroke(linienDicke));
		g2.drawArc(x - radius, y - radius, radius * 2, radius * 2, 0, 360);
	}
}
