import java.util.Scanner;
public class Print_Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number:");
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		//declaring first,second,three variable of fibonacci
		int first,second,third;
		first = 0;
		second = 1;
		third = first+second;
		//while loop for checking the condition for checking all fibonacci
		//numbers which are less than the given number
		while(first<N) {
			System.out.println(first);
			first=second;
			second=third;
			third = first+second;
		}

	}

}
