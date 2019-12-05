package grafikEditor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditorMouseAdapter extends MouseAdapter {
	private EditorControl controller;
	
	public EditorMouseAdapter(EditorControl controller) {
		super();
		this.controller = controller;
	}	
	
	@Override
	public void mousePressed(MouseEvent e) {
		 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseReleased(e);
	}

}
