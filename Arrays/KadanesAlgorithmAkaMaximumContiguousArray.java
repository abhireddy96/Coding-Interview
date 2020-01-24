/**
 * Problem: Find the sum of contiguous subarray within a one-dimensional array
 * of numbers which has the largest sum.
 * 
 * Solution:
 * Idea is to maintain maximum (positive sum) sub-array “ending” at each index of the given array. 
 * This subarray is either empty (in which case its sum is zero) or consists of 
 * one more element than the maximum subarray ending at the previous index
 * 
 * References: 
 * https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 * https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d
 */

public class KadanesAlgorithmAkaMaximumContiguousArray {

	// Function to find contiguous sub-array with the largest sum
	// in given set of integers (handles negative numbers as well)
	public static int findMaxContiguousArray(int[] A) {
		
		// Stores maximum sum sub-array found so far
		int globalMaximum = A[0];

		// Stores maximum sum of sub-array ending at current position
		int localMaximum = A[0];

		for (int i = 1; i < A.length; i++) {
			
			// maximum sum is should be more than the current element
			localMaximum = Integer.max(localMaximum + A[i], A[i]);

			// update result if current sub-array sum is found to be greater
			globalMaximum = Integer.max(globalMaximum, localMaximum);
		}

		return globalMaximum;
	}

	public static void main(String[] args) {
		System.out.println("The sum of contiguous subarray with the " + "largest sum is "
				+ findMaxContiguousArray(new int[] { -8, -3, -6, -2, -5, -4 }));
	}
}
