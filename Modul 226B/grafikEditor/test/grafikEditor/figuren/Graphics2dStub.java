package grafikEditor.figuren;

public class Graphics2dStub extends ConcreteGraphics {

	int numberOfDrawArcCalls;
	int x;
	int y;
	int radius;
	
	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		numberOfDrawArcCalls++;
		this.x = x;
		this.y = y;
		this.radius = width / 2;
	}
	
	
}
