/*
 * Problem:
 * Given two sorted arrays, a[] and b[], task is to find the median of these sorted arrays.
 * 
 * Solution:
 * 
 * References:
 * https://www.geeksforgeeks.org/median-two-sorted-arrays-different-sizes-ologminn-m/
 * https://medium.com/@dimko1/median-of-two-sorted-arrays-b7f0c4284159
 */
public class MedianOfTwoSortedArrays {

	// Function to find median of two sorted arrays
	static double findMedianSortedArrays(int a[], int b[], int n, int m) {

		int minIndex = 0, maxIndex = n;
		int i = 0, j = 0, median = 0;

		while (minIndex <= maxIndex) {
			i = (minIndex + maxIndex) / 2;
			j = ((n + m + 1) / 2) - i;

			// if i = n, it means that elements from a[] in the second half is an empty set.
			// if j = 0, it means that Elements from b[] in the first half is an empty set.
			// searching on right
			if (i < n && j > 0 && b[j - 1] > a[i])
				minIndex = i + 1;

			// if i = 0, it means that elements from a[] in the first half is an empty set.
			// if j = m, it means that Elements from b[] in the second half is an empty set.
			// searching on left
			else if (i > 0 && j < m && b[j] < a[i - 1])
				maxIndex = i - 1;

			else {
				// when we don't have any elements in the first half from a[]
				// so returning the last element in b[] from the first half.
				if (i == 0)
					median = b[j - 1];

				// when we don't have any elements in the first half from b[]
				// so returning the last element in a[] from the first half.
				else if (j == 0)
					median = a[i - 1];

				else
					median = Integer.max(a[i - 1], b[j - 1]);
				
				break;
			}
		}

		// If number of elements is odd, there is one middle element.
		if ((n + m) % 2 == 1)
			return (double) median;

		// Elements from a[], second half is an empty set.
		if (i == n)
			return (median + b[j]) / 2.0;

		// Elements from b[], second half is an empty set.
		if (j == m)
			return (median + a[i]) / 2.0;

		return (median + Integer.min(a[i], b[j])) / 2.0;
	}

	public static void main(String args[]) {
		int[] a = new int[] { 900 };
		int[] b = new int[] { 10, 13, 14 };

		int n = a.length;
		int m = b.length;

		if (n < m)
			System.out.print("The median is : " + findMedianSortedArrays(a, b, n, m));
		else
			System.out.print("The median is : " + findMedianSortedArrays(a, b, m, n));
	}

}
