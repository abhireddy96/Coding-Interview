import java.util.Arrays;

/*
 * Problem:
 * Given an array n positive & negative integers, find a subsequence of size k whose 
 * product is maximum among all possible k sized subsequences of the given array.
 * 
 * Input : A[] = {1, 2, -1, -3, -6, 4},  k = 4
 * Output : 144
 * 
 * Solution:
 *  Sort Array in ascending order, so that max can be found at extreme ends 
 *  Find product of k integers from right
 *  Now remove right element from product and by adding left element to it
 *  Check for K number of times and compute max at each step by comparing with maximum so far
 * 
 * References:
 * https://www.geeksforgeeks.org/maximum-product-subsequence-size-k/
 */
public class MaximumProductOfKSubsequentIintegers {

	private static int findMaximumProduct(int[] arr, int k) {

		int n = arr.length - 1;
		int h = n - k + 1;

		// Sort Array in ascending order
		Arrays.sort(arr);

		//Find product of k integers from right
		int rightMax = 1;
		for (int i = n; i >= h; i--)
			rightMax *= arr[i];

		int globalMax = rightMax;
		int leftMax = rightMax;

		// Find product from left side
		for (int j = 0; j < k; j++) {
			leftMax /= arr[h + j];
			leftMax *= arr[j];
			globalMax = Integer.max(globalMax, leftMax);
		}
		return globalMax;
	}

	public static void main(String[] args) {
		System.out.println(findMaximumProduct(new int[] { 10, 5, 25, -11, -8 }, 3));
	}
}
