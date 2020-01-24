/**
 * Problem:
 * FInd Maximum value in an array after m range increment operations.
 * 
 * Solution:
 * Perform two things in a single operation:
 * 1- Add k-value to only lower_bound of a range.
 * 2- Reduce upper_bound + 1 index by k-value.
 * After all operations, add all values, check the maximum sum and print maximum sum.
 * 
 * References:
 * https://www.geeksforgeeks.org/maximum-value-array-m-range-increment-operations/
 * https://massivealgorithms.blogspot.com/2017/04/maximum-value-in-array-after-m-range.html
 */

class MaximumValueInArrayAfterMRangeIncrementOperations
{

	// Function to find maximum value after 'm' operations
	private static long findMax(int n, int a[], int b[], int k[])
	{
		int []arr = new int[n + 1];

		// Start performing 'm' operations
		for (int i = 0; i < a.length; i++)
		{
			// Store lower and upper
			// index i.e. range
			int start = a[i];
			int end = b[i];

			// Add k to the lower_bound
			arr[start] += k[i];

			// Reduce upper_bound+1
			arr[end + 1] -= k[i];
		}

		long sum = 0, res = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i)
		{
			sum += arr[i];
			res = Math.max(res, sum);
		}
		return res;
	}

	// Driver code
	public static void main (String[] args)
	{
		// Number of values
		int n = 5;

		int a[] = {0, 1, 2};
		int b[] = {1, 4, 3};
		int k[] = {100, 100, 100};

		System.out.println("Maximum value after "+ "'m' operations is " +findMax(n, a, b, k));
	}
}
