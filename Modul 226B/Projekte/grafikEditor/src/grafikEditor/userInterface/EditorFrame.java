package grafikEditor.userInterface;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
	private EditorControl editorControl = new EditorControl();

	public EditorFrame(int breite, int hoehe) {
		erzeugeUndSetzeEditorPanel();
		fensterEinmitten(breite, hoehe);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		registerKeyListener();
		setVisible(true);
	}

	private void registerKeyListener() {
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_R:
					editorControl.setFigurTyp('r');
					break;
				case KeyEvent.VK_L:
					editorControl.setFigurTyp('l');
					break;
				case KeyEvent.VK_K:
					editorControl.setFigurTyp('k');
					break;
				case KeyEvent.VK_D:
					editorControl.setFigurTyp('d');
					break;
				case KeyEvent.VK_E:
					editorControl.setFigurTyp('e');
					break;
				case KeyEvent.VK_S:
					editorControl.saveZeichung();
					break;
				case KeyEvent.VK_0:
					editorControl.loadZeichnung();
					repaint();
					break;
				}
			}

		});
	}

	private void erzeugeUndSetzeEditorPanel() {
		JPanel panel = new EditorPanel(editorControl);
		setContentPane(panel);
	}

	private void fensterEinmitten(int breite, int hoehe) {
		Dimension bildschirmGroesse = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle fensterAusschnitt = new Rectangle();
		fensterAusschnitt.width = breite;
		fensterAusschnitt.height = hoehe;
		fensterAusschnitt.x = (bildschirmGroesse.width - fensterAusschnitt.width) / 2;
		fensterAusschnitt.y = (bildschirmGroesse.height - fensterAusschnitt.height) / 2;
		setBounds(fensterAusschnitt);
	}
}
