package sortAlgorithms.bubbleSort;

public class BubbleSort {
	private int[] list;

	public BubbleSort(int[] list) {
		this.list = list;
	}

	public int[] sort() {
		int n = list.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (list[j] > list[j + 1]) {
					swap(j, j+1);
				}
			}
		}
		return list;
	}

	public int[] mySort() {
		int sortCounter = 0;
		do {
			sortCounter = 0;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1]) {
					swap(i, i + 1);
					sortCounter++;
				}
			}
		} while (sortCounter != 0);
		return list;
	}

	private void swap(int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

}
