package vererbung_und_referenzen;

class Firma {
	private Person[] mitarbeiter;

	public Firma(Person[] p) {
		mitarbeiter = p;
	}
}

class Person {
	protected String name;
	protected String vorname;
	protected int personalNummer;

	public Person(String name, String vorname, int personalNummer) {
		this.name = name;
		this.vorname = vorname;
		this.personalNummer = personalNummer;
	}
}

class Chef extends Person {
	private String abteilung;

	public Chef(String name, String vorname, int personalNummer, String abteilung) {
		super(name, vorname, personalNummer);
		this.abteilung = abteilung;
	}
}

class Fachangestellter extends Person {
	private Chef vorgesetzter;

	public Fachangestellter(String name, String vorname, int personalNummer, Chef vorgesetzer) {
		super(name, vorname, personalNummer);
		this.vorgesetzter = vorgesetzer;
	}
}

public class Personen {
	public static void main(String[] args) {
		Firma f = new Firma(new Person[] { new Chef("Sattler", "Beatrice", 25, "Verkauf") });
		
		Person person = new Person("test", "test", 1);
		Chef chef = new Chef("Hans", "Müller", 2, "Verkauf");
		
	}
}
