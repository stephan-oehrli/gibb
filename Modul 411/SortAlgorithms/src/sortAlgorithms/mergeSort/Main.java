package sortAlgorithms.mergeSort;

import sortAlgorithms.ListGenerator;

public class Main {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		ListGenerator generator = new ListGenerator();
		int[] unsortedList = generator.generateRandomList(1000000);
		long start = System.currentTimeMillis();
		int[] sortedList = mergeSort.mergeSort(unsortedList);
		System.out.println(System.currentTimeMillis() - start);
	}
}
