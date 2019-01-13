package lect_14;

public class MergeSortLinkedList extends LinkedList {
	static Node<Integer> getMidNode(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> head;
		Node<Integer> tail;
		if (head1.data.compareTo(head2.data) < 0) {
			head = head1;
			tail = head1;
			head1 = head1.next;
		} else {
			head = head2;
			tail = head2;
			head2 = head2.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data.compareTo(head2.data) < 0) {
				tail.next = head1;
				tail = tail.next;
				head1 = head1.next;
			} else {
				tail.next = head2;
				tail = tail.next;
				head2 = head2.next;
			}
		}
		while (head1 != null) {
			tail.next = head1;
			tail = tail.next;
			head1 = head1.next;
		}
		while (head2 != null) {
			tail.next = head2;
			tail = tail.next;
			head2 = head2.next;
		}
		return head;

	}

	static Node<Integer> mergeSort(Node<Integer> head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> mid = getMidNode(head);
		Node<Integer> head2 = mid.next;
		mid.next = null;
		Node<Integer> left = mergeSort(head);
		Node<Integer> right = mergeSort(head2);
		return merge(left, right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head = prepareLinkedList();
		head = mergeSort(head);
		PrintLinkedlist(head);

	}

}
