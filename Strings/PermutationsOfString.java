import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of an ordered list S into a one-to-one correspondence with S itself. 
 * A string of length n has n! permutation.
 * 
 * Solution:
 * The idea is to swap each of the remaining characters in the string with its first character 
 * and then find all the permutations of the remaining characters using a recursive call. 
 * The base case of the recursion is when the string is left with only one unprocessed element. 
 * 
 * References:
 * https://www.geeksforgeeks.org/print-all-permutations-of-a-string-with-duplicates-allowed-in-input-string/
 * https://www.techiedelight.com/find-permutations-given-string/
 *
 */

public class PermutationsOfString {

	// Utility function to swap two characters in a character array
	private static void swap(char[] ch, int i, int j)
	{
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}
	
	// Utility function to check if Swapping should be done
	private static boolean shouldSwap(char chars[], int start, int end) { 
        for (int i = start; i < end; i++) { 
            if (chars[i] == chars[end]) { 
                return false; 
            } 
        } 
        return true; 
    } 

	// Recursive function to generate all permutations of a String
	private static void permutations(char[] chars, int currentIndex, List<String> list)
	{
		if (currentIndex == chars.length - 1) {
			list.add(String.valueOf(chars));
		}

		for (int i = currentIndex; i < chars.length; i++)
		{
			if(shouldSwap(chars, currentIndex, i)) {
			swap(chars, currentIndex, i); // Swap index for permutation purpose
			permutations(chars, currentIndex + 1, list);
			swap(chars, currentIndex, i); // Reverse Swap to get original String
			}
		}
	}

	public static void main(String[] args)
	{
		String s = "ABC";
		List<String> permutationResult = new LinkedList<>();
		permutations(s.toCharArray(), 0, permutationResult);
		System.out.println(permutationResult.toString());
	}

}
