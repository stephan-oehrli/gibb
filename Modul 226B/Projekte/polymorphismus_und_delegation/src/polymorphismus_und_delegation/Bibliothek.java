package polymorphismus_und_delegation;

public class Bibliothek {

	private Medium[] katalog;

	public void showSample(Medium m) {
		if (m instanceof Buch) {
			System.out.println(((Buch) m).sample);
		} else if (m instanceof CD) {
			Player p = new Player();
			p.playSound(((CD) m).sample);
		} else if (m instanceof DVD) {
			Player p = new Player();
			p.playVideo(((DVD) m).sample);
		}
	}

}

abstract class Medium {}

class Buch extends Medium {
	String sample;
}

class CD extends Medium {
	Sound sample;
}

class DVD extends Medium {
	Video sample;
}

class Sound {}
class Video {}

class Player {
	public void playVideo(Video sample) {
	}
	
	public void playSound(Sound sample) {
	}
}