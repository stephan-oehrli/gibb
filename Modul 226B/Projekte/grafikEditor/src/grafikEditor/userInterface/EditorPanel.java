package grafikEditor.userInterface;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorPanel extends JPanel {
	private EditorControl editorControl;

	EditorPanel(EditorControl control) {
		editorControl = control;
		registerMouseListener();
	}

	private void registerMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				editorControl.setErsterPunkt(new Point(e.getX(), e.getY()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				editorControl.erzeugeFigurMitZweitemPunkt(new Point(e.getX(), e.getY()));
				editorControl.setzeFarbeZurueck();
				repaint();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				editorControl.erzeugeFigurMitZweitemPunkt(new Point(e.getX(), e.getY()));
				repaint();
			}			
		});
	}

	// Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
	// Methode beim EditorFrame oder beim EditorPanel aufruft.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		editorControl.allesNeuZeichnen(g);
	}
}