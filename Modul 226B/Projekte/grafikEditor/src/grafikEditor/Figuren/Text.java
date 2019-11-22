package grafikEditor.Figuren;

import java.awt.Color;
import java.awt.Font;

public class Text extends Figur{
	String inhalt;
	Font schriftart = new Font("Arial", 0, 12);
	
	public Text(int x, int y, String inhalt) {
		this(x, y, inhalt, null);
	}
	
	public Text(int x, int y, String inhalt, Color linienFarbe) {
		super(x, y, linienFarbe);
		this.inhalt = inhalt;
	}

	public char[] getInhalt() {
		return inhalt.toCharArray();
	}

	public Font getSchriftart() {
		return schriftart;
	}

	public void setSchriftart(Font schriftart) {
		this.schriftart = schriftart;
	}

	@Override
	public void skalieren(float faktor) {
		schriftart = schriftart.deriveFont(schriftart.getSize() * faktor);
	}
}
