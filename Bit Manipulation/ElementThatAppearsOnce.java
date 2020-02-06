/*
 * Problem:
 * Given an array where every element occurs three times, except one element which occurs only once. 
 * Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
 * 
 * Solution:
 * Run a loop for all elements in array. At the end of every iteration, maintain
 * ones: The bits that have appeared 1st time or 4th time or 7th time .. etc.
 * twos: The bits that have appeared 2nd time or 5th time or 8th time .. etc.
 * Finally, return the value of ‘ones’
 * 
 * References:
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 */
public class ElementThatAppearsOnce {

	// Method to find the element that occur only once
	static int getSingle(int[] arr, int n) {
		int ones = 0, twos = 0;
		int commonBitMask;

		for (int i = 0; i < n; i++) {
			// "one & arr[i]" gives the bits that are there in both 'ones' and new element from arr
			// add these bits to 'twos' using bitwise OR
			twos = twos | (ones & arr[i]);

			ones = ones ^ arr[i];

			// common bits are those bits which appear third time
			// So these bits should not be there in both 'ones' and 'twos'.
			// commonBitMask contains all these bits as 0, so that the bits can be removed
			// from 'ones' and 'twos'
			commonBitMask = ~(ones & twos);

			// Remove common bits (the bits that appear third time) from 'ones'
			ones &= commonBitMask;

			// Remove common bits (the bits that appear third time) from 'twos'
			twos &= commonBitMask;
		}
		return ones;
	}

	public static void main(String args[]) {
		int arr[] = { 3, 3, 2, 3 };
		int n = arr.length;
		System.out.println("The element with single occurrence is " + getSingle(arr, n));
	}

}
