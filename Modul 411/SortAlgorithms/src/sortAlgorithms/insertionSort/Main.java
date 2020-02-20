package sortAlgorithms.insertionSort;

import sortAlgorithms.ListGenerator;

public class Main {

	public static void main(String[] args) {
		ListGenerator generator = new ListGenerator();
		int[] unsortedList = generator.generateRandomList(30000);
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
}
