package gameOfLife;

public class Main {

	public static void main(String[] args) {
		try {
			new GameOfLife(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

	}

}
