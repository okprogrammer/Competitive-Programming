package PriorityQueue;

public class MaxPriorityQueue<T> extends CustomPriorityQueue<T> {

	protected void shiftUp(int index) {
		int parentIndex = getParentIndex(index);
		if (parentIndex == -1) {
			return;
		}
		if (heap.get(parentIndex).priority < heap.get(index).priority) {
			swap(index, parentIndex);
			shiftUp(parentIndex);
		} else {
			return;
		}

	}

	protected void shiftDown(int index) {

		 int minIndex = index;
	        int leftChildIndex = 1;
	        int rightChildIndex = 2;

	        while (leftChildIndex<heap.size()){
	            if(heap.get(leftChildIndex).priority>heap.get(minIndex).priority){
	                minIndex = leftChildIndex;
	            }
	            if(rightChildIndex<heap.size() && heap.get(rightChildIndex).priority>heap.get(minIndex).priority){
	                minIndex = rightChildIndex;
	            }
	            if(minIndex==index){
	                break;
	            }else {
	                swap(minIndex,index);
	                index = minIndex;
	                leftChildIndex = 2*index+1;
	                rightChildIndex = 2*index+2;
	            }
	        }
	}

}
