import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 * Problem:
 * Given a string with repeated characters, the task is to 
 * rearrange characters in a string so that no two adjacent characters are same.
 * 
 * Solution:
 * Build a max heap, on the basis of the frequency of character
 * Pop an element and add it to the result, Decrease frequency by ‘1’
 * Push the previous element back into the heap if it’s frequency > ‘0’
 * Make the current element as the previous element for the next iteration.
 * 
 * References:
 * https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
 * https://www.geeksforgeeks.org/rearrange-characters-in-a-string-such-that-no-two-adjacent-are-same-using-hashing/
 */
public class RearrangeAdjacentCharacters {

	static class Key {
		int freq;
		char ch;

		Key(int val, char c) {
			freq = val;
			ch = c;
		}

	}

	static class KeyComparator implements Comparator<Key> {

		public int compare(Key k1, Key k2) {
			return (k2.freq - k1.freq);

		}
	}

	// Function to rearrange character of a string
	static String rearrangeString(String str) {
		int n = str.length();

		// Store frequencies of all characters in string
		Map<Character, Integer> counter = new LinkedHashMap<>();

		for (Character c : str.toCharArray())
			if (counter.containsKey(c))
				counter.put(c, counter.get(c) + 1);
			else
				counter.put(c, 1);

		// Insert all characters with their frequencies into a priority_queue
		PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());

		for (Entry<Character, Integer> entry : counter.entrySet())
			pq.add(new Key(entry.getValue(), entry.getKey()));

		StringBuilder resString = new StringBuilder();

		// initial previous element be( '#' and it's frequency '-1' )
		Key prev = new Key(-1, '#');

		while (!pq.isEmpty()) {

			// pop top element from queue and add to string
			Key current = pq.poll();
			resString.append(current.ch);

			// If frequency of previous character is less, need not to push it
			if (prev.freq > 0)
				pq.add(prev);

			// make current as the previous, decrease frequency
			current.freq--;
			prev = current;
		}

		// if length is not same then string is not valid
		if (n != resString.length())
			return " Not valid String ";
		else
			return resString.toString();
	}

	public static void main(String args[]) {
		System.out.println(rearrangeString("bbbaa"));
	}

}
