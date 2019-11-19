package grafikEditor.Figuren;

public class Dreieck extends Figur {
	int breite;
	int hoehe;

	public Dreieck(int x, int y, int breite, int hoehe) {
		super(x, y);
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public int[] getXPunkte() {
		return new int[] {x - breite / 2, x, x + breite / 2};
	}
	
	public int[] getYPunkte() {
		return new int[] {y + hoehe / 2, y - hoehe / 2, y + hoehe / 2};
	}
}
