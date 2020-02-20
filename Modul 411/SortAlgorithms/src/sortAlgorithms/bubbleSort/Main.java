package sortAlgorithms.bubbleSort;

import sortAlgorithms.ListGenerator;

public class Main {

	public static void main(String[] args) {
		int[] givenList = new int[] { 0, 9, 4, 6, 2, 8, 5, 1, 7, 3 };
		int[] randomList = new ListGenerator().generateRandomList(10000);
		BubbleSort bubbleSort = new BubbleSort(randomList);
		Long start = System.currentTimeMillis();
		int[] sortedList = bubbleSort.sort();
		System.out.println(System.currentTimeMillis() - start);
	}

}
