
public class Main {
	
	public static void main(String[] args) {
		
		Chef chef = new Chef("Heinz", "Müller", 1);
		Angestellter angestellter = new Angestellter("Roland", "Maurer", 2);
		Person[] personen = {chef, angestellter};
		
		for (Person person : personen) {
			System.out.println("Ich heisse " + person.getVorname() + " " + person.getName() + " und bin ein " + person.getClass().getTypeName());
		}
		
	}
}
