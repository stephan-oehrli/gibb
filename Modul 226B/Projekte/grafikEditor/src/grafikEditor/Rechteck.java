package grafikEditor;

public class Rechteck extends Figur {
	private int breite;
	private int hoehe;
	
	public Rechteck(int x, int y, int breite, int hoehe) {
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
