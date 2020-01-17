package grafikEditor.figuren;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class KreisTest {
	private Graphics2dStub g2 = new Graphics2dStub();
	
	
	@Test
	void testZeichneFigur() {
		int radius = 10;
		Kreis kreis = new Kreis(20, 30, radius);
		kreis.zeichneFigur(g2);
		assertEquals(1, g2.numberOfDrawArcCalls);
		assertEquals(20 - radius, g2.x);
		assertEquals(30 - radius, g2.y);
		assertEquals(radius, g2.radius);
	}

}
