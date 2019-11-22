package grafikEditor.Figuren;

import java.util.ArrayList;
import java.util.List;

public class FigurGruppe extends Figur {
	private List<Figur> gruppe = new ArrayList<>();
	
	public FigurGruppe() {
		super(0, 0, null);
	}
	
	public void hinzufuegen(Figur figur) {
		gruppe.add(figur);
	}
	
	public void hinzufuegen(List<Figur> figuren) {
		gruppe.addAll(figuren);
	}
	
	public void entfernen(Figur figur) {
		gruppe.remove(figur);
	}

	@Override
	public void move(int deltaX, int deltaY) {
		for (Figur figur : gruppe) {
			figur.move(deltaX, deltaY);
		}
	}
}
