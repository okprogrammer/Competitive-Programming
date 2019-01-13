package PriorityQueue;

public class TestPriorityQueue {
	public static void main(String[] args) throws Exception {
		CustomPriorityQueue<String> queue = new MaxPriorityQueue<String>();
		try {
			queue.insert("Aman", 20);
			queue.insert("Suman", 90);
			queue.insert("Raman", 120);
			queue.insert("Abc", 1020);
			queue.insert("Cdef", 0);
			
			System.out.println(queue.getHighestPriorityData());
			
			System.out.println(queue.deleteHighestPriority());
			
			System.out.println(queue.deleteHighestPriority());
			
			System.out.println(queue.deleteHighestPriority());
			System.out.println(queue.deleteHighestPriority());
			System.out.println(queue.deleteHighestPriority());
		}
		catch(Exception e) {
			System.out.println("Error is showing?");
		}
		
		
		
	}
}
