package polymorphismus_und_delegation;

public class Bibliothek {

	private Medium[] katalog;

	public void showSample(Medium m) {
		m.showSample();
	}
}

abstract class Medium {
	public abstract void showSample();
}

class Buch extends Medium {
	String sample;

	@Override
	public void showSample() {
		System.out.println(sample);
	}
}

class CD extends Medium {
	Sound sample;

	@Override
	public void showSample() {
		Player p = new Player();
		p.playSound(sample);
	}
}

class DVD extends Medium {
	Video sample;

	@Override
	public void showSample() {
		Player p = new Player();
		p.playVideo(sample);
	}
}

class Sound {}
class Video {}

class Player {
	public void playVideo(Video sample) {}
	public void playSound(Sound sample) {}
}