package stack_queues;

class QueueUnderFlowException extends Exception{
	
}

public class QueueUsingSinglyList<T> {
	private Node<T> tail = null;
	private Node<T> head = null;
	void Enqueue(T data) {
		Node<T> node = new Node<>(data);
		if(head == null) {
			head = node;
			tail = node;
			node.next = null;
		}
		tail.next = node;
		tail = node;
		node.next = null;
		System.out.println("Adding element in queue: "+tail.data);
	}
	T DeQueue() throws QueueUnderFlowException {
		if(head==null) {
			QueueUnderFlowException obj = new QueueUnderFlowException();
			throw obj;
		}
		Node<T> node = head;
		head = head.next;
		return node.data;
	}
  
}
