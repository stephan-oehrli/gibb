package grafikEditor.importExport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import grafikEditor.figuren.Figur;

public class FigurSaver {
	
	public void save(List<Figur> zeichnungen) {
		try (FileWriter writer = new FileWriter("figuren.txt")) {
			BufferedWriter bw = new BufferedWriter(writer);
			for (Figur figur : zeichnungen) {
				bw.write(figur.toString());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
