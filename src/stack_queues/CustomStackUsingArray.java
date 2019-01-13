package stack_queues;

class OurStackUnderFlowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

public class CustomStackUsingArray {
	private int[] arr;

	public CustomStackUsingArray() {
		arr = new int[10];
	}

	public CustomStackUsingArray(int size) {
		arr = new int[size];
	}

	private int top = -1;

	public void push(int data) {
		if (isFull()) {
			extendStack();
		}
		++top;
		System.out.println("Pushed: "+data);
		arr[top] = data;
	}

	private void extendStack() {
		int[] temp = arr;
		arr = new int[temp.length * 2];
		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
		System.out.println("Size "+temp.length+" To "+ arr.length);
	}

	public boolean isFull() {
		if(top == arr.length - 1){
			return true;
		}
		return false;
	}

	public int pop() throws OurStackUnderFlowException {
		if (isEmpty()) {
			throw new OurStackUnderFlowException();
		}
		int temp = arr[top--];
		System.out.println("Popped: "+ temp);
		return temp;
	}

	public boolean isEmpty() {

		return top == -1;
	}


}
