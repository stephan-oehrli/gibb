package grafikEditor.Figuren;

import java.awt.Color;

public class Figur {
	protected int x;
	protected int y;
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getLinienFarbe() {
		return linienFarbe;
	}

	public void setLinienFarbe(Color linienFarbe) {
		this.linienFarbe = linienFarbe;
	}

	public int getLinienDicke() {
		return linienDicke;
	}

	public void setLinienDicke(int linienDicke) {
		this.linienDicke = linienDicke;
	}
}
