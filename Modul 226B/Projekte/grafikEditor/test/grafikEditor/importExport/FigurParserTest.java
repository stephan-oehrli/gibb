package grafikEditor.importExport;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import grafikEditor.figuren.Figur;
import grafikEditor.figuren.Kreis;
import grafikEditor.figuren.Linie;
import grafikEditor.figuren.Rechteck;

class FigurParserTest {

	FigurDAO figurDAO = new FigurDaoStub();
	FigurParser parser = new FigurParser(figurDAO);
	
	@Test
	void testCreate3Figures() {
		List<Figur> figuren = parser.parse();
		assertEquals(3, figuren.size());
	}
	
	@Test
	void createRechteck() {
		List<Figur> figuren = parser.parse();
		Rechteck rechteck = (Rechteck) figuren.get(0);
		
		assertEquals("Rechteck", rechteck.getClass().getSimpleName());
		assertEquals(10, rechteck.getX());
		assertEquals(10, rechteck.getY());
		assertEquals(30, rechteck.getBreite());
		assertEquals(20, rechteck.getHoehe());
	}
	
	@Test
	void createKreis() {
		List<Figur> figuren = parser.parse();
		Kreis kreis = (Kreis) figuren.get(1);
		
		assertEquals("Kreis", kreis.getClass().getSimpleName());
		assertEquals(10, kreis.getX());
		assertEquals(10, kreis.getY());
		assertEquals(20, kreis.getRadius());
	}
	
	@Test
	void createLinie() {
		List<Figur> figuren = parser.parse();
		Linie linie = (Linie) figuren.get(2);
		
		assertEquals("Linie", linie.getClass().getSimpleName());
		assertEquals(10, linie.getX());
		assertEquals(10, linie.getY());
		assertEquals(30, linie.getEndX());
		assertEquals(20, linie.getEndY());
	}

}

