
public abstract class Person {
    private String name;
    private String vorname;
    private int mitarbeiterId;

    public Person(String vorname, String nachname, int mitarbeiterId) {
    	this.name = nachname;
    	this.vorname = vorname;
    	this.mitarbeiterId = mitarbeiterId;
    }

    String getName() {
        return this.name;
    }

    String getVorname() {
        return this.vorname;
    }

    int getMitarbeiterId() {
        return this.mitarbeiterId;
    }

    void setName(String value) {
        this.name = value;
    }

    void setVorname(String value) {
        this.vorname = value;
    }

    void setMitarbeiterId(int value) {
        this.mitarbeiterId = value;
    }

}
