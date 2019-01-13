package thread;

class A extends Thread{
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("from ThreadA"+i);
		}
		System.out.println("Exit from A");
	}
}

class B extends Thread{
	public void run() {
		for (int i = 0; i <= 5; i++) {
			if(i==2) {
				yield();
			}
			
			System.out.println("from ThreadB"+i);
		}
		System.out.println("Exit from B");
	}
}
class C extends Thread{
	public void run() {
		for (int i = 0; i <= 5; i++) {
			System.out.println("from ThreadC"+i);
		}
		System.out.println("Exit from C");
	}
}
public class ThreadTest {

	public static void main(String[] args) {
		
		new A().start();
		new B().start();
		new C().start();

	}

}
