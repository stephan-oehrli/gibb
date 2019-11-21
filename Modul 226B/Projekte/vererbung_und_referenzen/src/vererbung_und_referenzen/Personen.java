package vererbung_und_referenzen;

class Firma {
	private Person[] mitarbeiter;

	public Firma(Person[] p) {
		mitarbeiter = p;
	}
}

abstract class Person {
	protected String name;
	protected String vorname;
	protected int personalNummer;

	public Person(String name, String vorname, int personalNummer) {
		this.name = name;
		this.vorname = vorname;
		this.personalNummer = personalNummer;
	}
	
	public void print() {
		System.out.println("---------------------------------");
		System.out.println("Personalnummer: " + personalNummer);
		System.out.println("Name: " + name);
		System.out.println("Vorname: " + vorname);
	}
	
	public abstract int berechneFerien(int alter);
}

class Chef extends Person {
	private String abteilung;

	public Chef(String name, String vorname, int personalNummer, String abteilung) {
		super(name, vorname, personalNummer);
		this.abteilung = abteilung;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Abteilung: " + abteilung);
	}

	@Override
	public int berechneFerien(int alter) {
		if (alter > 55) {
			return 6;
		}
		return (alter >= 45) ? 5 : 4;
	}
}

class Fachangestellter extends Person {
	private Chef vorgesetzter;

	public Fachangestellter(String name, String vorname, int personalNummer, Chef vorgesetzer) {
		super(name, vorname, personalNummer);
		this.vorgesetzter = vorgesetzer;
	}

	@Override
	public int berechneFerien(int alter) {
		if (alter > 60) {
			return 6;
		}
		return (alter >= 50) ? 5 : 4;
	}
}

class Lernender extends Person {
	int lehrjahr;
	
	public Lernender(String name, String vorname, int personalNummer, int lehrjahr) {
		super(name, vorname, personalNummer);
		this.lehrjahr = lehrjahr;
	}

	@Override
	public void print() {
		super.print();
		System.out.println("Lehrjahr: " + lehrjahr + ". Lehrjahr");
	}

	@Override
	public int berechneFerien(int alter) {
		return 5;
	}
}

public class Personen {
	public static void main(String[] args) {
//		Firma f = new Firma(new Person[] { new Chef("Sattler", "Beatrice", 25, "Verkauf") });
		
		Chef chef = new Chef("Hans", "Müller", 1, "Verkauf");
		Fachangestellter fachangestellter = new Fachangestellter("Anna", "Frey", 2, chef);
		Lernender lernender = new Lernender("Julian", "Lüthi", 3, 2);
		
		Person[] angestellte = new Person[] {chef, fachangestellter, lernender};
		for (Person person : angestellte) {
			person.print();
			System.out.println("Der Ferienanspruch beträgt: " + person.berechneFerien(46) + " Wochen");
		}
	}
}
