package muffinRezept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;


public class MuffinRezept {
	
	public static void main(String[] args) {
		int numberOfPersons = 0;
		System.out.println("Für wieviele Personen willst du Muffins backen? Bitte gib die Anzahl der Personen an: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			 numberOfPersons = Integer.parseInt(in.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		boolean appleTime = new Date().getMonth() > 7 && new Date().getMonth() < 10;
		Ingredients ingredients = new Ingredients();
		Bowl bowl = new Bowl();
		MuffinMoulding[] muffinMouldings = new MuffinMoulding[2 * numberOfPersons];
		Oven oven = new Oven();
		
		bowl.add(ingredients.getButterInGrams(50 * numberOfPersons));
		bowl.add(ingredients.getSugarInGrams(50 * numberOfPersons));
		bowl.add(ingredients.getEggs(numberOfPersons));
		bowl.add(ingredients.getBakingPowderBags(numberOfPersons / 4));
		bowl.add(ingredients.getVanillaSugarBags(numberOfPersons / 4));
		bowl.add(ingredients.getFlourInGrams(60 * numberOfPersons));
		bowl.add(ingredients.getRumSpoons(numberOfPersons / 3));
		if (appleTime) {
			bowl.add(ingredients.getApples(numberOfPersons / 3));
		} else {
			bowl.add(ingredients.getChocolateInGrams(25 * numberOfPersons));
		}
		oven.open();
		for (int i = 0; i < muffinMouldings.length; i++) {
			muffinMouldings[i] = new MuffinMoulding();
			muffinMouldings[i].add(bowl.getMixture());
			oven.insert(muffinMouldings[i]);
		}
		oven.close();
		oven.setTemperatureInGrad(190);
		oven.setTimeInMinutes(30);
		oven.bake();
		while (oven.getBakingTime() != 0) {
			oven.checkContent();
		}
		oven.open();
		BakedMuffin[] bakedMuffins = oven.getBakedMuffins();
		oven.close();
		for (BakedMuffin bakedMuffin : bakedMuffins) {
			bakedMuffin.dust(ingredients.getPowderedSugarInGrams(20));
		}
		
		System.out.println("Voila, hier sind " + bakedMuffins.length + " frisch gebackene " + (appleTime ? "Apfel-" : "Schoko-") +  "Muffins. Mmmmh, Lecker!");
		
	}
	
}
