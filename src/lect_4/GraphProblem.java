package lect_4;
import java.util.Scanner;

public class GraphProblem {
	//function for checking point is valid or not
	public static boolean check_pt(int x,int y) {
		if(x==1 && y==1) {
			return true;
		}
		else if(y==x || y==x-2) {
			return true;
		}
		else {
			return false;
		}
	}
	//function for calculating sum
	public static void calc_sum(int x, int y) {
		int sum;
		if(check_pt(x,y) && x%2==0) {
			sum=x+y;
			System.out.println(sum);
		}
		if(check_pt(x,y) && x%2!=0) {
			sum=x+y-1;
			System.out.println(sum);
		}
	}

	public static void main(String[] args) {
		//creating the scanner object s 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of x");
		int x = s.nextInt();
		System.out.println("Enter the value of y");
		int y = s.nextInt();
		boolean t = check_pt(x,y);
		if(t) {
			System.out.println("Point is valid!");
		}
		else {
			System.out.println("Point is not valid!");
		}
		calc_sum(x,y);

	}

}
