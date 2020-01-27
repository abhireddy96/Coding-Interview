import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Problem:
 * Given k sorted linked lists each of size n, merge them in sorted order as it is.
 * 
 * Solution:
 * Construct a min-heap of size K and insert first node of each list into it. 
 * Then pop root node (having minimum value) from the heap 
 * and insert next node from “same” list as popped node. 
 * Repeat this process until the heap is exhausted.
 * 
 * References:
 * https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
 * https://www.techiedelight.com/efficiently-merge-k-sorted-linked-lists/
 */
public class MergeKSortedLinkedLists {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	// function to merge k sorted linked lists
	public static Node mergeKSortedLists(Node arr[], int k) {
		Node head = null, last = null;

		// PriorityQueue implemented as min heap with help of 'compare' function
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node a, Node b) {
				return a.data - b.data;
			}
		});

		// push the head nodes of all the k lists
		for (int i = 0; i < k; i++)
			if (arr[i] != null)
				pq.add(arr[i]);

		while (!pq.isEmpty()) {
			// get the top element
			Node top = pq.peek();
			pq.remove();

			// check if there is a node next to the 'top' node
			// in the list of which 'top' node is a member
			if (top.next != null)
				// push the next node
				pq.add(top.next);

			// if final merged list is empty
			if (head == null) {
				head = top;
				last = top;
			} else {
				// insert 'top' at the end of the merged list so far
				last.next = top;
				last = top;
			}
		}
		return head;
	}

	// function to print the singly linked list
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		
		int k = 3; // Number of linked lists
		Node arr[] = new Node[k]; // Array of pointers storing the head nodes of the linked lists

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		// Merge all lists
		Node head = mergeKSortedLists(arr, k);
		printList(head);
	}
}
