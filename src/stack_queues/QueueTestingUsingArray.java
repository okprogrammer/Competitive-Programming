package stack_queues;

public class QueueTestingUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    QueueUsingArray queue = new QueueUsingArray();
		
		
		for(int i =0;i<100;i++){
			try {
				queue.Enqueue(i);
			} catch (QueueOverFlowException e) {
				System.out.println("queue is full!");
			}
		}
		
		while(!queue.isEmpty()) {
			try {
				System.out.println("element Dequeued: "+queue.Dequeue());
			} catch (QueueUnderFlowException e) {
				// TODO Auto-generated catch block
				System.out.println("queue is Empty!");;
			}
		}
	}

}
