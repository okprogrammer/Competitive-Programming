package lect_15;

import java.util.*;

class Node<T> {
	T data;
	Node<T> next;

	Node(T d) {
		data = d;
	}
}

class BigNode<T> {
	Node<T> NewHead;
	Node<T> deletedNode;

	BigNode(Node<T> a, Node<T> b) {
		NewHead = a;
		deletedNode = b;
	}
}

public class SwapTwoNumber {
	static Node<Integer> prepareLinkedList() {
		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;
		while (data != -1) {
			Node<Integer> temp = new Node<Integer>(data);
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		return head;
	}

	static void PrintLinkedlist(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	static BigNode<Integer> deletedNode(Node<Integer> head, int i) {
		Node<Integer> temp = head, prev = null;
		if (i == 0) {
			prev = head;
			head = head.next;
			BigNode<Integer> node = new BigNode<>(head, prev);
			return node;
		}
		int count = 0;
		while (count < i) {
			prev = temp;
			temp = temp.next;
			count++;
		}
		if (temp == null) {
			return (new BigNode<>(head, null));
		}
		prev.next = prev.next.next;
		return (new BigNode<>(head, temp));
	}

	static Node<Integer> insertNode(Node<Integer> deletedNode, Node<Integer> NewHead, int i) {
		Node<Integer> temp = NewHead;
		if (i == 0) {
			deletedNode.next = temp;
			temp = deletedNode;
			return temp;
		}
		int count = 0;
		while (count < i - 1) {
			temp = temp.next;
			count++;
		}
		if (temp == null) {
			return NewHead;
		}
		deletedNode.next = temp.next;
		temp.next = deletedNode;
		return NewHead;
	}

	static Node<Integer> swapTwoNode(Node<Integer> head, int i, int j) {
		if (i == j) {
			return head;
		}
		if (i < j) {
			BigNode<Integer> first = deletedNode(head, i);
			BigNode<Integer> second = deletedNode(first.NewHead, j - 1);
			head = insertNode(second.deletedNode, second.NewHead, i);
			head = insertNode(first.deletedNode, head, j);
		} else {
			BigNode<Integer> first = deletedNode(head, j);
			BigNode<Integer> second = deletedNode(first.NewHead, i - 1);
			head = insertNode(second.deletedNode, second.NewHead, j);
			head = insertNode(first.deletedNode, head, i);
		}
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = prepareLinkedList();
		head = swapTwoNode(head, 0, 7);
		PrintLinkedlist(head);
	}
}
