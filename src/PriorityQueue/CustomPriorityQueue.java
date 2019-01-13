package PriorityQueue;

import java.util.ArrayList;

public abstract class CustomPriorityQueue<T> {

	final int LIMIT = 100000;
	protected ArrayList<HeapNode<T>> heap;

	public CustomPriorityQueue(int size) {
		heap = new ArrayList<>(size);
	}

	public CustomPriorityQueue() {
		heap = new ArrayList<>();
	}

	public void insert(T data, int priority) {
		HeapNode<T> node = new HeapNode<>(data, priority);
		heap.add(node);
		shiftUp(heap.size() - 1);
	}

	protected abstract void shiftUp(int i);

	protected abstract void shiftDown(int i);

	public T getHighestPriorityData() {
		return heap.get(0).data;
	}

	public T deleteHighestPriority() throws Exception {
		if(heap.size()==0) {
			throw new Exception("heap is empty!");
		}
		T data = heap.get(0).data;
		heap.set(0, heap.get(size() - 1));
		heap.remove(size() - 1);
		shiftDown(0);
		return data;
	}

	public int size() {
		return heap.size();
	}

	protected void swap(int index, int parentIndex) {
		HeapNode<T> temp = heap.get(parentIndex);
		heap.set(parentIndex, heap.get(index));
		heap.set(index, temp);
	}
    
	// getting the parent index of the heap node
	protected int getParentIndex(int index) {
		if (index == 0) {
			return -1;
		}
		return (index - 1) / 2;
	}
    
	//getting left child index of the heap node
	protected int getLeftChild(int index) {
		int left = 2 * index + 1;
		if (left > size()) {
			return -1;
		}
		return left;
	}
    
	//getting right child index  of the heap node
	protected int getRightChild(int index) {
		int right = 2 * index + 2;
		if (right > size()) {
			return -1;
		}
		return right;
	}
}
