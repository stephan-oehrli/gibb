package grafikEditor;

public class Linie extends Figur {
	private int endX;
	private int endY;
	
	public Linie(int x, int y, int endX, int endY) {
		super(x, y);
		this.endX = endX;
		this.endY = endY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}
}
