package grafikEditor.figuren;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figur {
	protected final int selectionAccuracy = 5;
	protected int x;
	protected int y;
	protected int drehungInGrad;
	protected int linienDicke = 1;
	protected Color linienFarbe;

	public Figur(int x, int y, Color linienFarbe) {
		this.x = x;
		this.y = y;
		this.linienFarbe = linienFarbe;
	}

	public abstract void skalieren(float faktor);

	public abstract void zeichneFigur(Graphics2D g2);

	public abstract boolean isFormTypeOf(String type);
	
	public abstract Figur clone(String[] figurArr);

	protected abstract boolean hasCursorFocus(int x, int y);

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void drehen(int grad) {
		this.drehungInGrad = grad;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setLinienFarbe(Color linienFarbe) {
		this.linienFarbe = linienFarbe;
	}

	public void setLinienDicke(int linienDicke) {
		this.linienDicke = linienDicke;
	}

	public double getDrehungInRad() {
		return Math.toRadians(drehungInGrad);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName().toLowerCase().charAt(0) + "," + x + "," + y;
	}
}
