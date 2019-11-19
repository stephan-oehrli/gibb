package grafikEditor.Figuren;

public class Ellipse extends Figur{
	int breite;
	int hoehe;
	
	public Ellipse(int x, int y, int breite, int hoehe) {
		super(x, y);
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public int getBreite() {
		return breite;
	}

	public int getHoehe() {
		return hoehe;
	}
}
