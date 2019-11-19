package grafikEditor.Figuren;

public class Text extends Figur{
	String inhalt;
	
	public Text(int x, int y, String inhalt) {
		super(x, y);
		this.inhalt = inhalt;
	}

	public char[] getInhalt() {
		return inhalt.toCharArray();
	}
}
