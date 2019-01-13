package lect_12;

import java.util.Scanner;

public class PrintBalancedParanthesis {
	static void printBalancedParanthesis(int n,int close,int open,String resultSoFar) {
		if(open == n && close == n) {
			System.out.println(resultSoFar);
			return;
		}
		else {
			if(open<n) {
				printBalancedParanthesis(n,close,open+1,resultSoFar+"(");
			}
			if(open>close) {
				printBalancedParanthesis(n,close+1,open,resultSoFar+")");
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        printBalancedParanthesis(n,0,0,"");
        
	}

}
