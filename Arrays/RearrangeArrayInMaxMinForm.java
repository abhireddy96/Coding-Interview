import java.util.Arrays;

/*
 *Problem:
 * Given a sorted array of positive integers, rearrange the array alternately 
 * i.e first element should be maximum value, second minimum value, 
 * third second max, fourth second min and so on. 
 * 
 * Solution:
 * Maintain two pointers one to leftmost or smallest element and other to rightmost or largest element. 
 * Move both pointers toward each other and alternatively copy elements at these pointers to an auxiliary array
 * 
 * References:
 * https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 */
public class RearrangeArrayInMaxMinForm {

	static int[] rearrange(int[] arr) {
		int n = arr.length;

		// Auxiliary array to hold modified array
		int res[] = new int[n];

		// Indexes of smallest and largest elements
		int small = 0, large = n - 1;

		// To indicate whether to copy largest or remaining smallest at next position
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			if (flag)
				res[i] = arr[large--];
			else
				res[i] = arr[small++];

			flag = !flag;
		}

		return res;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println("Modified Array : " + Arrays.toString(rearrange(arr)));

	}
}
