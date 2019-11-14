package vererbung_und_referenzen;

@SuppressWarnings("unused")
class Firma {
	
	private Person[] mitarbeiter;

	public Firma(Person[] p) {
		mitarbeiter = p;
	}
}

@SuppressWarnings("unused")
class Person {
	private String name;
	private String vorname;
	private int personalNummer;

	public Person(String name, String vorname, int personalNummer) {
		this.name = name;
		this.vorname = vorname;
		this.personalNummer = personalNummer;
	}
}

@SuppressWarnings("unused")
class Chef extends Person {
	private String abteilung;

	public Chef(String name, String vorname, int personalNummer, String abteilung) {
		super(name, vorname, personalNummer);
		this.abteilung = abteilung;
	}
}

class Fachangestellter extends Person {
	protected Chef vorgesetzter;

	public Fachangestellter(String name, String vorname, int personalNummer, Chef vorgesetzer) {
		super(name, vorname, personalNummer);
		this.vorgesetzter = vorgesetzer;
	}
}

@SuppressWarnings("unused")
public class Personen {
	public static void main(String[] args) {
		Firma f = new Firma(new Person[] { new Chef("Sattler", "Beatrice", 25, "Verkauf") });
	}
}
