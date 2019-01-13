package stack_queues;

public class StackPracticeUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomStackUsingArray st1 = new CustomStackUsingArray();

		for (int i = 0; i < 100; i++) {
			st1.push(i);
		}
		try {
			while(!st1.isEmpty()){
				st1.pop();
			}
		} catch (OurStackUnderFlowException e) {
			System.out.println();
		}

	}

}
