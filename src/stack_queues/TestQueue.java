package stack_queues;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingSinglyList<Integer> queue = new QueueUsingSinglyList<>();
		for (int i = 0; i < 10; i++) {
			queue.Enqueue(i);
		}
		try {
			for (int i = 0; i < 100; i++) {
				System.out.println(queue.DeQueue());
				;
			}
		} catch (QueueUnderFlowException e) {
			System.out.println("Queue is Empty!");
		}
	}

}
