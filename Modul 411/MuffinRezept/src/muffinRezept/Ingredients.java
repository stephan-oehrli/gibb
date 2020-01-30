package muffinRezept;

public class Ingredients {
	private int butterInGrams = 200;
	private int sugarInGrams = 200;
	private int eggs = 4;
	private double bakingPowderBags = 1;
	private double vanillaSugarBags = 1;
	private int flourInGrams = 250;
	private double rumSpoons = 3;
	
	private int apples = 3;
	private int chocolateInGrams = 100;
	private int powderedSugarInGrams = 100;
	
	public int getButterInGrams(int grams) {
		butterInGrams -= grams;
		return grams;
	}
	public int getSugarInGrams(int grams) {
		sugarInGrams -= grams;
		return grams;
	}
	public int getEggs(int eggs) {
		this.eggs -= eggs;
		return eggs;
	}
	public double getBakingPowderBags(int bags) {
		bakingPowderBags -= bags;
		return bags;
	}
	public double getVanillaSugarBags(int bags) {
		vanillaSugarBags -= bags;
		return bags;
	}
	public int getFlourInGrams(int grams) {
		flourInGrams -= grams;
		return grams;
	}
	public double getRumSpoons(int spoons) {
		rumSpoons -= spoons;
		return spoons;
	}
	public int getApples(int apples) {
		this.apples -= apples;
		return apples;
	}
	public int getChocolateInGrams(int grams) {
		chocolateInGrams -= grams;
		return grams;
	}
	public int getPowderedSugarInGrams(int grams) {
		powderedSugarInGrams -= grams;
		return grams;
	}
}
