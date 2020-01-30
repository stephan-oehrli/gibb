package grafikEditor.figuren;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

class ZeichnungTest {

	Zeichnung zeichnung = new Zeichnung();
	Graphics g = mock(Graphics2D.class);
	
	@Test
	void zeichneFiguren() {
		int radius = 5;
		zeichnung.hinzufuegen(new Rechteck(20, 10, 30, 40));
		zeichnung.hinzufuegen(new Kreis(20, 10, radius));
		zeichnung.hinzufuegen(new Linie(20, 10, 30, 40));
		zeichnung.zeichneFiguren(g);
		
		InOrder inOrder = inOrder(g);
		inOrder.verify(g, times(1)).drawRect(20, 10, 30, 40);
		inOrder.verify(g, times(1)).drawArc(20 - radius, 10 - radius, radius * 2, radius * 2, 0, 360);
		inOrder.verify(g, times(1)).drawLine(20, 10, 30, 40);
	}

}
