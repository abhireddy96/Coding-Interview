import java.util.LinkedList;
import java.util.List;

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
