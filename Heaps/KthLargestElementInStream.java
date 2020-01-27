import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Problem:
 * Given an infinite stream of integers, find the k’th largest element at any point of time.
 * 
 * Solution:
 * Create Min Heap of size k to store k largest elements of stream. 
 * The k’th largest element is always at root and can be found in O(1) time.
 * If new element is smaller, then ignore it. Otherwise replace root with new element.
 * 
 * References:
 * https://www.geeksforgeeks.org/kth-largest-element-in-a-stream/
 * https://www.techiedelight.com/find-kth-largest-element-array/
 */
public class KthLargestElementInStream {
	
	// Function to find the K'th largest element in stream
	public static int FindKthLargest(List<Integer> stream, int k)
	{
		// PriorityQueue as min heap and insert first k elements of the array into the heap
		PriorityQueue<Integer> pq = new PriorityQueue<>(stream.subList(0, k));

		// do for remaining array elements
		for (int i = k; i < stream.size(); i++)
		{
			// if current element is more than the root of the heap
			if (stream.get(i) > pq.peek())
			{
				// replace root with the current element
				pq.poll();
				pq.add(stream.get(i));
			}
		}

		// return the root of min-heap
		return pq.peek();
	}


	public static void main(String[] args)
	{
		System.out.println("K'th largest element in the array is " +
				FindKthLargest(Arrays.asList(7, 4, 6, 3, 9, 1), 2));
	}

}
