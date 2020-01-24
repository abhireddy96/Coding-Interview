import java.util.Stack;

/**
 * Problem: Given an array A of size N having distinct elements, the task is to
 * find the next greater element for each element of the array in order of their
 * appearance in the array.
 * 
 * Solution: 1. Mark the current element as next. 2. If stack is not empty,
 * compare top element of stack with next. 3. If next is greater than the top
 * element,Pop element from stack. next is the next greater element for the
 * popped element. 4. Keep popping from the stack while the popped element is
 * smaller than next. next becomes the next greater element for all such popped
 * elements
 * 
 * 
 * References: https://www.geeksforgeeks.org/next-greater-element/
 *
 */
public class NextLargerElementInArray {

	// Function to print all elements which are greater than all
	// elements present to its right
	public static void findNextGreatest(int[] arr) {

		Stack<Integer> stack = new Stack<>();

		int element;
		int next;

		/* push the first element to stack */
		stack.push(arr[0]);

		// iterate for rest of the elements
		for (int i = 1; i < arr.length; i++) {
			next = arr[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				// If the popped element is smaller than next, then print the pair
				// and keep popping while elements are smaller and stack is not empty
				while (element < next) {
					System.out.println(element + " --> " + next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				// If element is greater than next, then push the element back
				if (element > next)
					stack.push(element);
			}

			// push next to stack so that we can find next greater for it
			stack.push(next);
		}

		// Remaining elements in stack do not have the next greater element,
		// so print -1 for them
		while (!stack.isEmpty()) {
			element = stack.pop();
			next = -1;
			System.out.println(element + " -- " + next);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 4, 6, 3, 5 };
		findNextGreatest(arr);
	}

}
