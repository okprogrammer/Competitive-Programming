package stack_queues;


class QueueOverFlowException extends Exception{
	
}

class QueueUnderFlowException extends Exception{
	
}

public class QueueUsingArray {
	int[] arr;
	int start = -1;
	int end = -1;
	int count = 0;
	QueueUsingArray(){
	   	arr = new int[10];
	}
    void Enqueue(int data) throws QueueOverFlowException{
    	if(isFull()) {
    		throw new QueueOverFlowException();
    	}
    	if(start==-1) {
    		start++;
    	}
    	end = (end+1)%arr.length;
    	arr[end] = data;
    	System.out.println("Enqueued data is "+arr[end]);
    	count++;
    }
    boolean isFull() {
		return count==arr.length;
	}
	int Dequeue() throws QueueUnderFlowException {
    	 if(isEmpty()) {
    		 throw new QueueUnderFlowException(); 
    	 }
    	 int temp = arr[start];
    	 start = (start+1)%arr.length;
    	 count--;
    	 if(count==0) {
    		 start = end = -1;
    	 }
    	 return temp;
    }
	 boolean isEmpty() {
		return count==0;
	}
}
