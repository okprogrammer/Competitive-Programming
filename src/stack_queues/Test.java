package stack_queues;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<10;i++){
			st.push(i);
		}
	try {
		for(int i=0;i<1000;i++){
            System.out.println(st.pop());
        }
	} catch (UnderflowException e) {
		
		 System.out.println("Stack is Empty!");
	}
      
	}

}
