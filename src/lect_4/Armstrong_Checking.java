package lect_4;
import java.util.Scanner;
import java.lang.Math;

public class Armstrong_Checking {
   static void check_Armstrong(int N) {
	   int temp = N;
		int digit = 0;
		//Counting the digit of a number
		while(temp!=0) {
			digit = digit+1;
			temp = temp/10;
		}
		temp = N;
		int rem = 0;
		int sum = 0;
		/*This while loop for checking number is Armstrong or not
		 *Here were are checking the sum of the digit to raise to the power of the no. of digit
		 *in the given number.if it is equal to the number
		 *Then it is called Armstrong number  */
		while(temp!=0) {
			rem = temp%10;
			sum = sum + (int)Math.pow(rem,digit);
			temp=temp/10;
		}
		//Checking the sum is equal to the number of not
		if(sum==N) {
		System.out.println("Armstring");
		}
		else
		{
			System.out.println("Not Armstrong");
		}

   }
	public static void main(String[] args) {
		//creating scanner object to take input
		Scanner s = new Scanner(System.in);
		//assigning input to the N
		int N = s.nextInt();
		check_Armstrong(N);
		
	}

}
