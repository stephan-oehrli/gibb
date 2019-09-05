package bank;

public class TestKonto {

	public static void main(String[] args) {

		Kunde inhaber1 = new Kunde("Meier", "Hans", 1);
		Kunde inhaber2 = new Kunde("Meyer", "Fritz", 2);
		Konto konto1 = new Konto(0.01, inhaber1);
		Konto konto2 = new Konto(0.02, inhaber2);

		konto1.einzahlen(500.75);
		konto1.verzinsen(365);
		System.out.println("Der Kunde " + konto1.getInhaber().getName() + " hat ein Konto.");
		System.out.println("Der Saldo des Kontos ist " + konto1.getSaldo());
		konto2.einzahlen(720.50);
		konto2.verzinsen(750);
		System.out.println("Der Kunde " + konto2.getInhaber().getName() + " hat ein Konto.");
		System.out.println("Der Saldo des Kontos ist " + konto2.getSaldo());
		konto2.einzahlen(200);
		System.out.println("Der Saldo des Kontos ist " + konto2.getSaldo());
		
		

	}

}
