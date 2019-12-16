package grafikEditor.userInterface;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JPanel;

public class StatusBar extends JPanel implements FigurTypSubscriber, MousePosSubscriber {
	private static final long serialVersionUID = 1L;
	private String[] funktionen = { "Auswahl", "Kreis", "Linie", "Rechteck", "Dreieck", "Ellipse" };
	private Label lblSelectedFunction = new Label("Funktion: ");
	private Label lblMouseCoordinates = new Label("Maus: ");

	public StatusBar() {
		super(new BorderLayout());
		add(lblSelectedFunction, BorderLayout.WEST);
		add(lblMouseCoordinates, BorderLayout.EAST);
	}

	@Override
	public void update(char figurTyp) {
		lblSelectedFunction.setText("Funktion: " + getFunktionName(figurTyp));
		lblSelectedFunction.invalidate();
		validate();
	}

	private String getFunktionName(char figurTyp) {
		for (String name : funktionen) {
			if (name.toLowerCase().charAt(0) == figurTyp)
				return name;
		}
		return "";
	}

	@Override
	public void update(Point mousePos) {
		lblMouseCoordinates.setText(String.format("Maus: x=%d, y=%d", mousePos.x, mousePos.y));
		lblMouseCoordinates.invalidate();
		validate();
	}
}
