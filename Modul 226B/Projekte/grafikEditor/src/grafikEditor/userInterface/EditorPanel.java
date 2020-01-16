package grafikEditor.userInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
final class EditorPanel extends JPanel implements FigurTypSubscriber {
	private EditorControl editorControl;
	private List<MousePosSubscriber> mousePosSubscribers = new ArrayList<>();

	EditorPanel(EditorControl control) {
		editorControl = control;
		editorControl.addFigurTypSubscriber(this);
		addMousePosSubscriber(control);
		setBackground(Color.white);
		registerMouseListener();
	}

	private void registerMouseListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				editorControl.erzeugeFigurMitErstemPunkt(new Point(e.getX(), e.getY()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				editorControl.prepareForNextFigur();
				repaint();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				mousePosSubscribers.forEach(subscriber -> subscriber.update(e.getPoint()));
				editorControl.aktualisiereFigurMitZweitemPunkt(new Point(e.getX(), e.getY()));
				repaint();
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				mousePosSubscribers.forEach(subscriber -> subscriber.update(e.getPoint()));
				repaint();			}			
		});
	}

	// Die paintComponent()-Methode wird automatisch aufgerufen, wenn irgendwer die repaint()-
	// Methode beim EditorFrame oder beim EditorPanel aufruft.
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		editorControl.allesNeuZeichnen(g);
	}
	
	public void addMousePosSubscriber(MousePosSubscriber subscriber) {
		mousePosSubscribers.add(subscriber);
	}
	
	public void removeMousePosSubscriber(MousePosSubscriber subscriber) {
		mousePosSubscribers.remove(subscriber);
	}

	@Override
	public void update(char figurTyp) {
		setCursor(new Cursor((figurTyp == 'a') ? Cursor.DEFAULT_CURSOR : Cursor.CROSSHAIR_CURSOR));
	}
}