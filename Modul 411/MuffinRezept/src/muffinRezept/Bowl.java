package muffinRezept;

public class Bowl {
	private Mixture mixture = new Mixture();
	
	public void add(double ingredient) {
		mixture.mix(ingredient);
	}
	
	public Mixture getMixture() {
		return mixture;
	}
}
