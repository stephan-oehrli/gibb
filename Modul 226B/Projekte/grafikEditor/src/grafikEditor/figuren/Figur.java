package grafikEditor.figuren;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Figur {
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

	public void move(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
	}

	public void drehen(int grad) {
		this.drehungInGrad = grad;
	}

	public abstract void skalieren(float faktor);

	public abstract void zeichneFigur(Graphics2D g2);

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
