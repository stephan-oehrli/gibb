package grafikEditor.userInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public final class EditorFrame extends JFrame {
	private EditorControl editorControl = new EditorControl();
	private EditorPanel editorPanel;

	public EditorFrame(int breite, int hoehe) {
		fensterEinmitten(breite, hoehe);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		erzeugeUndSetzeEditorPanel();
		buildMenu();
		buildToolbar();
		buildStatusbar();
		registerKeyListener();
		setVisible(true);
	}

	private void erzeugeUndSetzeEditorPanel() {
		editorPanel = new EditorPanel(editorControl);
		setContentPane(editorPanel);
		setLayout(new BorderLayout());
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

	private void buildMenu() {
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		
		JMenu datei = new JMenu("Datei");
		bar.add(datei);
		
		JMenuItem oeffnen = new JMenuItem("Öffnen");
		oeffnen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		oeffnen.addActionListener(listener -> {
			editorControl.loadZeichnung();
			repaint();
		});
		datei.add(oeffnen);
		
		JMenuItem speichern = new JMenuItem("Speichern");
		speichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		speichern.addActionListener(listener -> {
			editorControl.saveZeichung();
		});
		datei.add(speichern);
		
		datei.addSeparator();
		
		JMenuItem beenden = new JMenuItem("Beenden");
		beenden.addActionListener(listener -> {
			System.exit(0);
		});
		datei.add(beenden);
	}

	private void buildToolbar() {
		JToolBar bar = new JToolBar();
		bar.setFloatable(false);
		bar.setMargin(new Insets(0, 3, 0, 0));
		add(bar, BorderLayout.NORTH);
		
		JButton btnPointer = new JButton(new ImageIcon("ressources/cursor.png"));
		btnPointer.setToolTipText("Figur wählen");
		btnPointer.setFocusable(false);
		btnPointer.addActionListener(listener -> editorControl.setFigurTyp('a'));
		bar.add(btnPointer);
		
		JButton btnRectangle = new JButton(new ImageIcon("ressources/rectangle.png"));
		btnRectangle.setToolTipText("Rechteck zeichnen");
		btnRectangle.setFocusable(false);
		btnRectangle.addActionListener(listener -> editorControl.setFigurTyp('r'));
		bar.add(btnRectangle);
		
		JButton btnLine = new JButton(new ImageIcon("ressources/line.png"));
		btnLine.setToolTipText("Linie zeichnen");
		btnLine.setFocusable(false);
		btnLine.addActionListener(listener -> editorControl.setFigurTyp('l'));
		bar.add(btnLine);
		
		JButton btnCircle = new JButton(new ImageIcon("ressources/circle.png"));
		btnCircle.setToolTipText("Kreis zeichnen");
		btnCircle.setFocusable(false);
		btnCircle.addActionListener(listener -> editorControl.setFigurTyp('k'));
		bar.add(btnCircle);
		
		JButton btnEllipse = new JButton(new ImageIcon("ressources/ellipse.png"));
		btnEllipse.setToolTipText("Ellipse zeichnen");
		btnEllipse.setFocusable(false);
		btnEllipse.addActionListener(listener -> editorControl.setFigurTyp('e'));
		bar.add(btnEllipse);
		
		JButton btnTriangle = new JButton(new ImageIcon("ressources/triangle.png"));
		btnTriangle.setToolTipText("Dreieck zeichnen");
		btnTriangle.setFocusable(false);
		btnTriangle.addActionListener(listener -> editorControl.setFigurTyp('d'));
		bar.add(btnTriangle);
	}

	private void buildStatusbar() {
		StatusBar statusBar = new StatusBar();
		editorControl.addFigurTypSubscriber(statusBar);
		editorPanel.addMousePosSubscriber(statusBar);
		add(statusBar, BorderLayout.SOUTH);
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
				}
			}
		});
	}
}
