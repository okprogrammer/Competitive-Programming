import java.util.Scanner;

public class Fibonacci_Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner num = new Scanner(System.in);
		System.out.println("Enter the Number");
		int n = num.nextInt();
		int a = 0, b = 1, c;
		c = a + b;
		while (a < n) {
			a = b;
			b = c;
			c = a + b;
		}
		if (a == n) {
			System.out.println("Member of Fibonacci number");
		}
			else {
			System.out.println("Not the member of fibonacci!");
		}

	}

}

