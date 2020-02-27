package recursion;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergeSortTest {
	private MergeSort mergeSort = new MergeSort();
	
	@Test
	public void merge1() {
		int[] sortedArr = mergeSort.merge(new int[] {1,3,5}, new int[]{2,3,6});
		assertArrayEquals(new int[] {1,2,3,3,5,6}, sortedArr);
	}
	
	@Test
	public void merge2() {
		int[] sortedArr = mergeSort.merge(new int[] {1,3,5}, new int[]{2,3});
		assertArrayEquals(new int[] {1,2,3,3,5}, sortedArr);
	}
	
	@Test
	public void merge3() {
		int[] sortedArr = mergeSort.merge(new int[] {1,3}, new int[]{2,3,5});
		assertArrayEquals(new int[] {1,2,3,3,5}, sortedArr);
	}
	
	@Test
	public void merge4() {
		int[] sortedArr = mergeSort.merge(new int[] {1,2,3}, new int[]{4,5,6});
		assertArrayEquals(new int[] {1,2,3,4,5,6}, sortedArr);
	}
	
	@Test
	public void merge5() {
		int[] sortedArr = mergeSort.merge(new int[] {4,5,6}, new int[]{1,2,3});
		assertArrayEquals(new int[] {1,2,3,4,5,6}, sortedArr);
	}
	
	@Test
	public void mergeSort1() {
		int[] sortedArr = mergeSort.mergeSort(new int[] {2,1});
		assertArrayEquals(new int[] {1,2}, sortedArr);
	}
	
	@Test
	public void mergeSort2() {
		int[] sortedArr = mergeSort.mergeSort(new int[] {1});
		assertArrayEquals(new int[] {1}, sortedArr);
	}
	
	@Test
	public void mergeSort3() {
		int[] sortedArr = mergeSort.mergeSort(new int[] {3,2,1,4});
		assertArrayEquals(new int[] {1,2,3,4}, sortedArr);
	}
	
	@Test
	public void mergeSort4() {
		int[] sortedArr = mergeSort.mergeSort(new int[] {3,2,1});
		assertArrayEquals(new int[] {1,2,3}, sortedArr);
	}
}
