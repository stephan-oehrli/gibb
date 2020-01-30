package muffinRezept;

import java.util.ArrayList;

public class Oven {

	private int temperature;
	private int time;
	private ArrayList<Object> contents = new ArrayList<>();
	
	public void open() {}

	public void insert(MuffinMoulding muffinMoulding) {
		contents.add(muffinMoulding);
	}

	public void close() {}

	public void setTemperatureInGrad(int temperature) {
		this.temperature = temperature;
	}

	public void setTimeInMinutes(int minutes) {
		this.time = minutes;
	}

	public void bake() {}
	
	public BakedMuffin[] getBakedMuffins() {
		BakedMuffin[] bakedMuffins = new BakedMuffin[contents.size()];
		for (int i = 0; i < bakedMuffins.length; i++) {
			bakedMuffins[i] = new BakedMuffin();
		}
		return bakedMuffins;
	}

	public int getBakingTime() {
		return time--;
	}

	public void checkContent() {}
}
