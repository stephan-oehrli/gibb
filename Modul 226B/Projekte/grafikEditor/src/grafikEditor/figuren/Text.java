package grafikEditor.figuren;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Text extends Figur {
	private String inhalt;
	private Font schriftart = new Font("Arial", 0, 12);

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

	public void setSchriftart(Font schriftart) {
		this.schriftart = schriftart;
	}

	@Override
	public void skalieren(float faktor) {
		schriftart = schriftart.deriveFont(schriftart.getSize() * faktor);
	}

	@Override
	public void zeichneFigur(Graphics2D g2) {
		if (getDrehungInRad() != 0) {
			g2.rotate(getDrehungInRad(), x, y);
		}
		g2.setColor(linienFarbe != null ? linienFarbe : Color.black);
		g2.setFont(schriftart);
		g2.drawChars(getInhalt(), 0, getInhalt().length, x, y);
	}

	@Override
	public boolean isFormTypeOf(String type) {
		return "t".equals(type);
	}
	
	@Override
	public Figur clone(String[] figurArr) {
		x = Integer.parseInt(figurArr[1]);
		y = Integer.parseInt(figurArr[2]);
		inhalt = figurArr[3];
		return new Text(x, y, inhalt);
	}

	@Override
	protected boolean hasCursorFocus(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}
}
