/**
 * Problem: Given a singly linked list, find middle of the linked list.
 * 
 * Solution:
 * Traverse linked list using two pointers. 
 * Move one pointer by one and other pointer by two. 
 * When the fast pointer reaches end slow pointer will reach middle of the linked
 * 
 * References:
 * https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 *
 */

class LinkedList {

	Node head;

	// Linked list node
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Function to print middle of linked list
	void printMiddle() {
		Node slow = head;
		Node fast = head;
		if (head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			System.out.println("The middle element is [" + slow.data + "] \n");
		}
	}

	// Inserts a new Node at front of the list.
	public void push(int data) {

		// Allocate the Node & Put in the data
		Node newNode = new Node(data);

		// Make next of new Node as head
		newNode.next = head;

		// Move the head to point to new Node
		head = newNode;
	}

	// This function prints contents of linked list starting from the given node
	public void printList() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + "->");
			cur = cur.next;
		}
		System.out.println("NULL");
	}
}

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		for (int i = 5; i > 0; --i) {
			list.push(i);
			list.printList();
			list.printMiddle();
		}
	}
}