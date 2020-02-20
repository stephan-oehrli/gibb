package insertionSort;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int[] unsortedList = generateRandomList(30000);
//		System.out.println(Arrays.toString(unsortedList));
		long start = System.currentTimeMillis();
		int[] sortedList = insertionSort(unsortedList);
		System.out.println(System.currentTimeMillis() - start);
//		System.out.println(Arrays.toString(sortedList));
	}

	private static int[] insertionSort(int[] liste) {
		for (int i = 1; i < liste.length; i++) {
			int key = liste[i];
			int j = i - 1;
			while (j >= 0 && liste[j] > key) {
				liste[j + 1] = liste[j];
				j--;
			}
			liste[j + 1] = key;
		}
		return liste;
	}
	
	private static int[] generateRandomList(int size) {
		Random random = new Random();
		int[] list = new int[size];
		for (int i = 0; i < list.length; i++) {
			list[i] = random.nextInt(100);
		}
		return list;
	}
}
