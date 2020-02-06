import java.util.Arrays;

/*
 * Problem:
 * Given two sorted arrays, the task is to merge them in a sorted manner
 * 
 * 
 * References:
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 */

public class MergeTwoSortedArrays {

	public static void mergeArraysWithExtraSpace(int[] arr1, int[] arr2, int[] arr3) {
		int i = 0, j = 0, k = 0;
		int n1 = arr1.length;
		int n2 = arr2.length;

		// Traverse both array
		while (i < n1 && j < n2) {
			// Check if current element of first array is smaller than current element of
			// second array.
			// If yes, store first array element and increment first array index.
			// Otherwise do same with second array
			if (arr1[i] < arr2[j])
				arr3[k++] = arr1[i++];
			else
				arr3[k++] = arr2[j++];
		}

		// Store remaining elements of first array
		while (i < n1)
			arr3[k++] = arr1[i++];

		// Store remaining elements of second array
		while (j < n2)
			arr3[k++] = arr2[j++];
	}

	static void mergeArraysWithoutExtraSpace(int[] arr1, int[] arr2) {

		int m = arr1.length;
		int n = arr2.length;

		for (int i = n - 1; i >= 0; i--) {
			// Find the smallest element greater than ar2[i].
			// Move all elements one position ahead till the smallest greater element is not
			// found
			int j;
			int last = arr1[m - 1];
			for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--)
				arr1[j + 1] = arr1[j];

			// If there was a greater element
			if (j != m - 2 || last > arr2[i]) {
				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };

		int[] arr2 = { 2, 4, 6, 8 };

		int[] arr3 = new int[arr1.length + arr2.length];

		mergeArraysWithExtraSpace(arr1, arr2, arr3);

		System.out.println("Array after merging with extra sapce: " + Arrays.toString(arr3));

		mergeArraysWithoutExtraSpace(arr1, arr2);

		System.out.println("Array after merging without extra sapce: " + Arrays.toString(arr1) + Arrays.toString(arr2));
	}

}
