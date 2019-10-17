package graphicalOutputJFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class swingCreatedWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	public swingCreatedWindow() throws HeadlessException {
		super("Mein Beispiel mit grafischer Ausgabe");

		Icon icon = new ImageIcon(getClass().getResource("gibbix.gif"));
		JLabel label = new JLabel("Java-Programme in der gibbix-Umgebung", icon, JLabel.CENTER);
		add(label);

		Font font = new Font("SansSerif", Font.BOLD, 20);
		label.setFont(font);
		label.setForeground(Color.blue);
		label.setBackground(Color.lightGray);
		label.setOpaque(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(750, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new swingCreatedWindow();
	}

}
