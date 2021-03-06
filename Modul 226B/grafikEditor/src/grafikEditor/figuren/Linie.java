package grafikEditor.figuren;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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

	@Override
	public void zeichneFigur(Graphics2D g2) {
		if (getDrehungInRad() != 0) {
			g2.rotate(getDrehungInRad(), getMittelpunktX(), getMittelpunktY());
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setStroke(new BasicStroke(linienDicke));
		g2.drawLine(x, y, endX, endY);
	}

	@Override
	public String toString() {
		return super.toString() + "," + endX + "," + endY + "," + linienFarbe;
	}

	@Override
	public boolean isFormTypeOf(String type) {
		return "l".equals(type);
	}
	
	@Override
	public Figur clone(String[] figurArr) {
		x = Integer.parseInt(figurArr[1]);
		y = Integer.parseInt(figurArr[2]);
		endX = Integer.parseInt(figurArr[3]);
		endY = Integer.parseInt(figurArr[4]);
		return new Linie(x, y, endX, endY);
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}
	
	public int getEndX() {
		return endX;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}
	
	public int getEndY() {
		return endY;
	}

	@Override
	protected boolean hasCursorFocus(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
