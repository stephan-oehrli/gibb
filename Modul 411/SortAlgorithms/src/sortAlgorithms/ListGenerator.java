package sortAlgorithms;
import java.util.Random;

public class ListGenerator {
	
	public int[] generateRandomList(int size) {
		Random random = new Random();
		int[] list = new int[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(100);
		}
		return list;
	}
}
