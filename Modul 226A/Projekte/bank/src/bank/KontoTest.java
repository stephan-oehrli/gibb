package bank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KontoTest {
	Kunde inhaber = new Kunde("Meier", "Hans", 1);
	private Konto konto;
	
	@Test
	public void einzahlenInt() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(3500);
		assertEquals(3500, konto.getSaldo(), 0);
	}
	
	@Test
	public void einzahlenKleinerBetrag() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(0.01);
		assertEquals(0.01, konto.getSaldo(), 0);
	}
	
	@Test
	public void einzahlenSehrGrosserBetrag() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(100000000000.0);
		assertEquals(100000000000.0, konto.getSaldo(), 0);
	}
	
	@Test
	public void einzahlenRunden() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(0.001);
		assertEquals(0.00, konto.getSaldo(), 0);
		konto.einzahlen(0.009);
		assertEquals(0.01, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsenErlaubteAnzahlTage() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(73);
		assertEquals(1020, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsenNegativeAnzahlTage() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(-73);
		assertEquals(1000, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsen0Tage() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(0);
		assertEquals(1000, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsenMaximaleTage() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(365);
		assertEquals(1100, konto.getSaldo(), 0);
	}
	
	@Test(expected = IllegalStateException.class)
	public void verzinsenZuvieleTage() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(366);
	}
	
	@Test
	public void verzinsenMitNegativemZins() {
		konto = new Konto(-0.1, inhaber);
		konto.einzahlen(1000);
		konto.verzinsen(365);
		assertEquals(900, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsenZinsWirdHalbiert() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(100000);
		konto.verzinsen(365);
		assertEquals(105000, konto.getSaldo(), 0);
	}
	
	@Test
	public void verzinsenKeinZins() {
		konto = new Konto(0.1, inhaber);
		konto.einzahlen(1000000);
		konto.verzinsen(365);
		assertEquals(1000000, konto.getSaldo(), 0);
	}
}
