import java.util.Arrays;

/*
 * References:
 * https://www.geeksforgeeks.org/heap-sort/
 */

public class HeapSort {

	public void sort(int arr[]) {
		int n = arr.length;

		// Build heap
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root or largest to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, 0, i);
		}
	}

	// To heapify a subtree rooted with node i and n is size of heap
	void heapify(int arr[], int i, int n) {
		int largest = i; // Initialize largest as root
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		// If left child is larger than root
		if (left < n && arr[left] > arr[largest])
			largest = left;

		// If right child is larger than largest
		if (right < n && arr[right] > arr[largest])
			largest = right;

		// If largest is not root , then swap
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };

		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);

		System.out.println("Sorted array is: " + Arrays.toString(arr));
		;
	}

}
