package PriorityQueue;

public class MinPriorityQueue<T> extends CustomPriorityQueue<T> {

	protected void shiftUp(int index) {
		int parentIndex = getParentIndex(index);
		if (parentIndex == -1) {
			return;
		}
		if (heap.get(parentIndex).priority > heap.get(index).priority) {
			swap(index, parentIndex);
			shiftUp(parentIndex);
		}

	}

	protected void shiftDown(int index) {
		// System.out.println(index);
		int leftChild = getLeftChild(index);
		int rightChild = getRightChild(index);
		int lowestPriorityIndex = -1;
		if (leftChild != -1 && rightChild != -1) {
			lowestPriorityIndex = heap.get(leftChild).priority < heap.get(rightChild).priority ? leftChild : rightChild;
		} else if (leftChild != -1) {
			lowestPriorityIndex = leftChild;
		}
		if (lowestPriorityIndex == -1) {
			return;
		}

		if (heap.get(lowestPriorityIndex).priority < heap.get(index).priority) {
			swap(lowestPriorityIndex, index);
			shiftDown(lowestPriorityIndex);
		} else {
			return;
		}

	}

}
