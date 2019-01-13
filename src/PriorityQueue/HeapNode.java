package PriorityQueue;

public class HeapNode<T> {
	T data;
	int priority;
	HeapNode(T data, int priority){
		this.data = data;
		this.priority = priority;
	}
}
