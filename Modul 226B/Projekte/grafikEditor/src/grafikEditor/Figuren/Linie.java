package grafikEditor.Figuren;

import java.awt.Color;

public class Linie extends Figur {
	private int endX;
	private int endY;

	public Linie(int x, int y, int endX, int endY) {
		this(x, y, endX, endY, null);
	}

	public Linie(int x, int y, int endX, int endY, Color linienFarbe) {
		super(x, y, linienFarbe);
		this.endX = endX;
		this.endY = endY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}
	
	public double getMittelpunktX() {
		return (x + endX) / 2;
	}
	
	public double getMittelpunktY() {
		return (y + endY) / 2;
	}

	@Override
	public void move(int deltaX, int deltaY) {
		super.move(deltaX, deltaY);
		endX += deltaX;
		endY += deltaY;
	}

	@Override
	public void skalieren(float faktor) {
		double mittelPunktX = getMittelpunktX();
		double mittelPunktY = getMittelpunktY();
		double differenzX = (mittelPunktX - x);
		double differenzY = (mittelPunktY - y);
		x = (int) (mittelPunktX - differenzX * faktor);
		y = (int) (mittelPunktY - differenzY * faktor);
		endX = (int) (mittelPunktX + differenzX * faktor);
		endY = (int) (mittelPunktY + differenzY * faktor);
	}
}
