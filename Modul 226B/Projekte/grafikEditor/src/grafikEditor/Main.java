package grafikEditor;

import grafikEditor.Figuren.Dreieck;
import grafikEditor.Figuren.Ellipse;
import grafikEditor.Figuren.Kreis;
import grafikEditor.Figuren.Linie;
import grafikEditor.Figuren.Rechteck;
import grafikEditor.Figuren.Text;

public class Main {
	
	private static final Display display = new Display();

	public static void main(String[] args) {
		Rechteck rechteck1 = new Rechteck(100, 100, 100, 50);
		Rechteck rechteck2 = new Rechteck(300, 300, 100, 50);
		
		Kreis kreis1 = new Kreis(100, 100, 25);
		Kreis kreis2 = new Kreis(300, 300, 200);

		Linie linie1 = new Linie(100, 150, 300, 350);
		Linie linie2 = new Linie(200, 100, 400, 300);
		
		Text text1 = new Text(400, 400, "Hallo");
		
		Ellipse ellipse1 = new Ellipse(415, 395, 50, 25);
		
		Dreieck dreieck1 = new Dreieck(300, 300, 400, 400);
		
		display.hinzufuegen(rechteck1);
		display.hinzufuegen(rechteck2);
		display.hinzufuegen(kreis1);
		display.hinzufuegen(kreis2);
		display.hinzufuegen(linie1);
		display.hinzufuegen(linie2);
		display.hinzufuegen(text1);
		display.hinzufuegen(ellipse1);
		display.hinzufuegen(dreieck1);
	}

}
