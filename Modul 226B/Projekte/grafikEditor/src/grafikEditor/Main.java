package grafikEditor;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import grafikEditor.Figuren.Dreieck;
import grafikEditor.Figuren.Ellipse;
import grafikEditor.Figuren.FigurGruppe;
import grafikEditor.Figuren.Kreis;
import grafikEditor.Figuren.Linie;
import grafikEditor.Figuren.Rechteck;
import grafikEditor.Figuren.Text;

public class Main {
	
	private static final Display display = new Display();

	public static void main(String[] args) {
		Zeichnung zeichnung1 = new Zeichnung(new ArrayList<>());
		
		Rechteck rechteck1 = new Rechteck(100, 100, 100, 50);
		rechteck1.setLinienDicke(3);
		Rechteck rechteck2 = new Rechteck(300, 300, 100, 50, Color.blue, Color.red);
		rechteck2.setLinienDicke(3);
		
		Kreis kreis1 = new Kreis(100, 100, 25, Color.red);
		Kreis kreis2 = new Kreis(300, 375, 124);
		kreis2.setLinienFarbe(Color.red);
		kreis2.setLinienDicke(2);

		Linie linie1 = new Linie(100, 150, 300, 350, Color.green);
		linie1.setLinienDicke(3);
		Linie linie2 = new Linie(200, 100, 400, 300, Color.orange);
		linie2.setLinienDicke(3);
		
		Dreieck dreieck1 = new Dreieck(300, 300, 400, 400, new Color(1f, 1f, 0f, .5f));
		
		Ellipse ellipse1 = new Ellipse(415, 395, 50, 25, new Color(0x8800FF));
		Text text1 = new Text(400, 400, "Hallo", Color.white);
		text1.setSchriftart(new Font("Arial", 1, 12));

		display.setZeichnung(zeichnung1);
		
		zeichnung1.hinzufuegen(rechteck1);
		zeichnung1.hinzufuegen(rechteck2);
		zeichnung1.hinzufuegen(kreis1);
		zeichnung1.hinzufuegen(kreis2);
		zeichnung1.hinzufuegen(linie1);
		zeichnung1.hinzufuegen(linie2);
		zeichnung1.hinzufuegen(dreieck1);
		zeichnung1.hinzufuegen(ellipse1);
		zeichnung1.hinzufuegen(text1);
		
		FigurGruppe figurGruppe1 = new FigurGruppe();
		figurGruppe1.hinzufuegen(Arrays.asList(kreis1, linie1, linie2, rechteck1, rechteck2));
		figurGruppe1.move(200, 0);
		
		FigurGruppe figurGruppe2 = new FigurGruppe();
		figurGruppe2.hinzufuegen(Arrays.asList(ellipse1, text1));
		figurGruppe2.move(-113, 0);
		
		FigurGruppe figurGruppe3 = new FigurGruppe();
		figurGruppe3.hinzufuegen(Arrays.asList(kreis1, rechteck1, linie1, linie2, figurGruppe2));
		figurGruppe3.skalieren(1.5f);
		
		dreieck1.skalieren(0.8f);
		dreieck1.drehen(45);
	}

}
