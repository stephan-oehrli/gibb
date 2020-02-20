package insertionSort;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		int size = 20;
		int[] liste = new int[size];
		for (int i = 0; i < liste.length; i++) {
			liste[i] = random.nextInt(100);
		}
		long start = System.currentTimeMillis();
		insertionSort(liste);
		System.out.println(System.currentTimeMillis() - start);
	}

	private static void insertionSort(int[] liste) {
		System.out.println(Arrays.toString(liste));
		
		for (int i = 1; i < liste.length; i++) {
			int key = liste[i];
			int j = i - 1;
			
			while (j >= 0 && liste[j] > key) {
				liste[j + 1] = liste[j];
				j--;
			}
			liste[j + 1] = key;
		}
		
		System.out.println(Arrays.toString(liste));
	}

	private static void mySort(int[] liste) {
		System.out.println(Arrays.toString(liste));
		for (int i = 0; i < liste.length - 1; i++) {
			int k = liste[i+1];
			if (liste[i] > k) {
				liste[i+1] = liste[i];
				liste[i] = k;
				i = -1;
			}
		}
		System.out.println(Arrays.toString(liste));
	}

}
