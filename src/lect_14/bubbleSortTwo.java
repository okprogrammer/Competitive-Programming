package lect_14;

public class bubbleSortTwo extends LinkedList {
	static int lengthNode(Node<Integer> head) {
		int i = 0;
		while (head != null) {
			head = head.next;
			i++;
		}
		return i;
	}

	static Node<Integer> bubbleSort(Node<Integer> head) {
		int n = lengthNode(head);
		Node<Integer> prev, curr;
		for (int i = 0; i < n; i++) {
			curr = head;
			prev = null;
			for (int j = 0; j < n - i - 1; j++) {
				if (curr.data < curr.next.data) {
					prev = curr;
					curr = curr.next;
				} else {
					if (prev == null) {
						Node<Integer> fwd = curr.next;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
						head = prev;
					} else {
						Node<Integer> fwd = curr.next;
						prev.next = fwd;
						curr.next = fwd.next;
						fwd.next = curr;
						prev = fwd;
					}
				}
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node<Integer> head = prepareLinkedList();
		head = bubbleSort(head);
		PrintLinkedlist(head);
	}
}
