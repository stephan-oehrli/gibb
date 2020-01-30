package grafikEditor;

import grafikEditor.userInterface.EditorFrame;

public final class Grafikeditor {

	public static void main(String[] args) {
		new Grafikeditor();
	}

	private Grafikeditor() {
		EditorFrame frame = new EditorFrame(800, 600);
	}
}
