package bank;

public class Konto {

	private double saldo;
	private double zinssatz;
	private Kunde inhaber;

	public Konto(double zinssatz, Kunde inhaber) {
		this.zinssatz = zinssatz;
		this.inhaber = inhaber;
	}

	public void einzahlen(double betrag) {
		if (betrag > 0)
			saldo += Math.round(betrag * 100.0) / 100.0;
	}

	public void verzinsen(int anzahlZuVerszinsendeTage) {
		if (saldo <= 500000 && anzahlZuVerszinsendeTage > 0) {
			if (anzahlZuVerszinsendeTage <= 365) {
				double zins = saldo * zinssatz * anzahlZuVerszinsendeTage / 365;
				saldo += (saldo > 50000) ? (zins / 2) : zins;
			} else {
				throw new IllegalStateException("Verzinsung von maximal 1 Jahr erlaubt");
			}
		}
	}

	public double getSaldo() {
		return Math.round(saldo * 100.0) / 100.0;
	}

	public Kunde getInhaber() {
		return inhaber;
	}
}
