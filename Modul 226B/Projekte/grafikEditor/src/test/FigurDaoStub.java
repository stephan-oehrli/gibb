package test;

import grafikEditor.importExport.FigurDAO;

public class FigurDaoStub implements FigurDAO {

	private String[] testFiguren = {"Rechteck 10 10 30 20", "Kreis 10 10 20", "Linie 10 10 30 20"};
	private int currentFigur;
	
	@Override
	public String[] readNextFigurData() {
		if (currentFigur < testFiguren.length) {
			String[] figurData = testFiguren[currentFigur].split("\\s");
			currentFigur++;
			return figurData;
		}
		return null;
	}

}
