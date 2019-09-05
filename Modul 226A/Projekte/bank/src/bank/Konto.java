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
		saldo += betrag;
	}

	public void verzinsen(int anzahlZuVerszinsendeTage) {
		double zins = saldo * zinssatz * anzahlZuVerszinsendeTage / 365;
		if (saldo > 50000 && saldo <= 500000) {
			saldo += zins / 2;
		} else if (saldo < 50000) {
			saldo += zins;
		}
	}

	public double getSaldo() {
		return Math.round(saldo * 100.0) / 100.0;
	}

	public Kunde getInhaber() {
		return inhaber;
	}
}
