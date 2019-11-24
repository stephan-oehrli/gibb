package grafikEditor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import grafikEditor.Figuren.Dreieck;
import grafikEditor.Figuren.Ellipse;
import grafikEditor.Figuren.Figur;
import grafikEditor.Figuren.Kreis;
import grafikEditor.Figuren.Linie;
import grafikEditor.Figuren.Rechteck;
import grafikEditor.Figuren.Text;

/**
 * Die Klasse Display stellt ein Fenster auf dem Bildschirm zur Verfügung, in
 * welchem Figur-Objekte dargestellt werden können. Siehe auch Java-Grundkurs
 * Abschnitt 10.2 und 10.3.
 * 
 * @author Andres Scheidegger
 */
@SuppressWarnings("serial")
public class Display extends JFrame {
	/** Die Liste der dargestellten Figur-Objekte */
	private List<Figur> figuren = new ArrayList<Figur>();

	/**
	 * Konstruktor. Initialisiert das Fenster in der Mitte des Bildschirms und
	 * erzeugt ein JFrame-Objekt, auf welchem die Figuren gezeichnet werden.
	 */
	public Display() {
		Dimension windowSize = new Dimension(800, 600);
		setSize(windowSize);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int windowPositionX = (screenSize.width - windowSize.width) / 2;
		int windowPositionY = (screenSize.height - windowSize.height) / 2;
		Point windowPosition = new Point(windowPositionX, windowPositionY);
		setLocation(windowPosition);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createAndAddDrawingPanel();
		setVisible(true);
	}

	private void createAndAddDrawingPanel() {
		// Das JPanel-Objekt ist ein Objekt einer anonymen Unterklasse von JPanel
		// Siehe Java-Grundkurs Abschnitt 3.9
		add(new JPanel() {
			// Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
			// Methode beim Dsiplay aufruft.
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				zeichneFiguren(g);
			}
		});
	}

	/**
	 * Zeichnet alle Figuren.
	 * 
	 * @param g Referenz auf das Graphics-Objekt zum zeichnen.
	 */
	private void zeichneFiguren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		AffineTransform old = g2.getTransform();
		for (Figur f : figuren) {
			if (f instanceof Rechteck) {
				Rechteck r = (Rechteck) f;
				if (r.getDrehungInRad() != 0) {
					g2.rotate(r.getDrehungInRad(), r.getX(), r.getY());
				}
				if (r.getFuellung() != null) {
					g.setColor(r.getFuellung());
					g.fillRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
				}
				g.setColor(r.getLinienFarbe() != null ? r.getLinienFarbe() : Color.black);
				g2.setStroke(new BasicStroke(r.getLinienDicke()));
				g.drawRect(r.getX(), r.getY(), r.getBreite(), r.getHoehe());
			}
			if (f instanceof Kreis) {
				Kreis k = (Kreis) f;
				if (k.getFuellung() != null) {
					g.setColor(k.getFuellung());
					g.fillArc(k.getX() - k.getRadius(), k.getY() - k.getRadius(), k.getRadius() * 2, k.getRadius() * 2, 0, 360);
				}
				g.setColor(k.getLinienFarbe() != null ? k.getLinienFarbe() : Color.black);
				g2.setStroke(new BasicStroke(k.getLinienDicke()));
				g.drawArc(k.getX() - k.getRadius(), k.getY() - k.getRadius(), k.getRadius() * 2, k.getRadius() * 2, 0, 360);
			}
			if (f instanceof Linie) {
				Linie l = (Linie) f;
				if (l.getDrehungInRad() != 0) {
					g2.rotate(l.getDrehungInRad(), l.getMittelpunktX(), l.getMittelpunktY());
				}
				g.setColor(l.getLinienFarbe() != null ? l.getLinienFarbe() : Color.black);
				g2.setStroke(new BasicStroke(l.getLinienDicke()));
				g.drawLine(l.getX(), l.getY(), l.getEndX(), l.getEndY());
			}
			if (f instanceof Text) {
				Text t = (Text) f;
				if (t.getDrehungInRad() != 0) {
					g2.rotate(t.getDrehungInRad(), t.getX(), t.getY());
				}
				g.setColor(t.getLinienFarbe() != null ? t.getLinienFarbe() : Color.black);
				g.setFont(t.getSchriftart());
				g.drawChars(t.getInhalt(), 0, t.getInhalt().length, t.getX(), t.getY());
			}
			if (f instanceof Ellipse) {
				Ellipse e = (Ellipse) f;
				if (e.getDrehungInRad() != 0) {
					g2.rotate(e.getDrehungInRad(), e.getX(), e.getY());
				}
				if (e.getFuellung() != null) {
					g.setColor(e.getFuellung());
					g.fillArc(e.getX() - e.getBreite() / 2, e.getY() - e.getHoehe() / 2, e.getBreite(), e.getHoehe(), 0, 360);
				}
				g.setColor(e.getLinienFarbe() != null ? e.getLinienFarbe() : Color.black);
				g2.setStroke(new BasicStroke(e.getLinienDicke()));
				g.drawArc(e.getX() - e.getBreite() / 2, e.getY() - e.getHoehe() / 2, e.getBreite(), e.getHoehe(), 0, 360);
			}
			if (f instanceof Dreieck) {
				Dreieck d = (Dreieck) f;
				if (d.getDrehungInRad() != 0) {
					g2.rotate(d.getDrehungInRad(), d.getX(), d.getY());
				}
				if (d.getFuellung() != null) {
					g.setColor(d.getFuellung());
					g.fillPolygon(d.getXPunkte(), d.getYPunkte(), 3);
				}
				g.setColor(d.getLinienFarbe() != null ? d.getLinienFarbe() : Color.black);
				g2.setStroke(new BasicStroke(d.getLinienDicke()));
				g.drawPolygon(d.getXPunkte(), d.getYPunkte(), 3);
			}
			g2.setTransform(old);
		}
	}

	/**
	 * Fügt eine weitere Figur hinzu und löst die Auffrischung des Fensterinhaltes
	 * aus.
	 * 
	 * @param figur Referenz auf das weitere Figur-Objekt.
	 */
	public void hinzufuegen(Figur figur) {
		figuren.add(figur);
		repaint();
	}

	/**
	 * Löscht alle Figuren und löst die Auffrischung des Fensterinhaltes aus.
	 */
	public void allesLoeschen() {
		figuren.clear();
		repaint();
	}
}
