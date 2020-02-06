import java.util.Arrays;

/*
 * Problem:
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. 
 * If array is already sorted then inversion count is 0. 
 * If array is sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * 
 * Solution:
 * Problem can be sorted using mergesort
 * Basically for each element of the array, we count all elements more than it to its left and add the count to output. 
 * Number of inversions is sum of inversions in left subarray, right subarray and merge().
 * 
 * References:
 * https://www.geeksforgeeks.org/counting-inversions/
 * https://www.techiedelight.com/inversion-count-array/
 */
public class InversionsOfArray {

	// Merge two sorted subarrays
	public static int merge(int[] arr, int[] aux, int low, int mid, int high) {
		int k = low, i = low, j = mid + 1;
		int inversionCount = 0;

		// While there are elements in the left and right runs
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				aux[k++] = arr[i++];
			} else {
				aux[k++] = arr[j++];
				inversionCount += (mid - i + 1);
			}
		}

		// Copy remaining elements
		while (i <= mid)
			aux[k++] = arr[i++];

		while (j <= high)
			aux[k++] = arr[j++];

		// copy back to the original array
		for (i = low; i <= high; i++) {
			arr[i] = aux[i];
		}

		return inversionCount;
	}

	// Sort array using auxiliary array aux
	public static int mergeSort(int[] arr, int[] aux, int low, int high) {
		// Base case
		// if run size == 1
		if (high == low) {
			return 0;
		}

		// find mid point
		int mid = low + (high - low) / 2;

		int inversionCount = 0;

		inversionCount += mergeSort(arr, aux, low, mid);

		inversionCount += mergeSort(arr, aux, mid + 1, high);

		inversionCount += merge(arr, aux, low, mid, high);

		return inversionCount;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 6, 4, 5 };
		int[] aux = Arrays.copyOf(arr, arr.length);

		System.out.println("Inversion count is " + mergeSort(arr, aux, 0, arr.length - 1));
	}
}
