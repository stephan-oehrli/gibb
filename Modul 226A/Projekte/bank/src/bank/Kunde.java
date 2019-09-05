package bank;

public class Kunde {

	private String name;
	private String vorname;
	private int kundenNummer;

	public Kunde() {

	}

	public Kunde(String name, String vorname, int kundenNummer) {
		this.name = name;
		this.vorname = vorname;
		this.kundenNummer = kundenNummer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public int getKundenNummer() {
		return kundenNummer;
	}

	public void setKundenNummer(int kundenNummer) {
		this.kundenNummer = kundenNummer;
	}

}
