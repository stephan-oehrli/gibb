package sortAlgorithms.mergeSort;

import java.util.Arrays;

public class MergeSort {

	public int[] mergeSort(int[] unsortedArr) {
		if (unsortedArr.length <= 1) {
			return unsortedArr;
		} else {
			int[] arr1 = Arrays.copyOfRange(unsortedArr, 0, unsortedArr.length / 2);
			int[] arr2 = Arrays.copyOfRange(unsortedArr, unsortedArr.length / 2, unsortedArr.length);
			return merge(mergeSort(arr1), mergeSort(arr2));
		}
	}

	public int[] merge(int[] arr1, int[] arr2) {
		int iArr1 = 0, iArr2 = 0, length = arr1.length + arr2.length;
		int[] sortedArr = new int[length];
		for (int i = 0; i < length; i++) {
			if (iArr1 < arr1.length && iArr2 < arr2.length) {
				sortedArr[i] = (arr1[iArr1] < arr2[iArr2]) ? arr1[iArr1++] : arr2[iArr2++];
			} else {
				sortedArr[i] = (iArr1 > arr1.length - 1) ? arr2[iArr2++] : arr1[iArr1++];
			}
		}
		return sortedArr;
	}
}
