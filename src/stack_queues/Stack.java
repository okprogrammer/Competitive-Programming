package stack_queues;


class UnderflowException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
public class Stack<T> {
	 private Node<T> top = null;
	    void push(T data) {
	        Node<T> temp = new Node<T>(data);
	        temp.next = top;
	        top = temp;
	        System.out.println("push element at the top "+top.data);
	    }

	    T pop() throws UnderflowException {
	        if(top==null) {
	            UnderflowException obj = new UnderflowException();
	            throw obj;
	        }
	        Node<T> temp = top;
	        top = top.next;
	        return temp.data;
	}
	
}
