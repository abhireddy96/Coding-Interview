import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given an unsorted array of integers, find a subarray which adds to a
 * given number
 * 
 * Solution: Maintain the sum of elements encountered so far in a variable (say
 * currentSum). Let the given number is the sum. Now for each element, we check
 * if curr_sum – sum exists in the map or not. If we found it in the map that
 * means, we have a subarray present with the given sum, else we insert curr_sum
 * into the map and proceed to the next element. If all elements of the array
 * are processed and we didn’t find any subarray with the given sum, then
 * subarray doesn’t exist.
 * 
 * References:
 * https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
 * https://www.techiedelight.com/find-subarrays-given-sum-array/
 *
 */
public class SubArrayWithGivenSum {

	// Find SubArray with given Sum
	private static boolean subArraySum(int arr[], int sum) {
		int currentSum = 0;
		int start = 0;
		int end = -1;
		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			currentSum = currentSum + arr[i];
			// check whether currentSum-sum=0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (currentSum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum, so stop
			if (map.containsKey(currentSum - sum)) {
				start = map.get(currentSum - sum) + 1;
				end = i;
			}

			// if value is not present then add to hashmap
			map.put(currentSum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
			return false;
		} else {
			System.out.println("Sum found between indexes " + start + " to " + end);
			return true;
		}
	}

	public static void main(String[] args) {
		subArraySum(new int[] { 15, 2, 4, 8, 9, 5, 10, 23 }, 22);
	}

}
