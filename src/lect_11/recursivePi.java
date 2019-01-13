package lect_11;

import java.util.Scanner;

public class recursivePi {
	
	static String replacePi(String input) {
		if(input.length()==1 || input.length()==0) {
			return input;
		}
		
		if(input.charAt(0)=='p' && input.charAt(1)=='i') {
			return 3.14+replacePi(input.substring(2));
		}
		else {
			return input.charAt(0)+replacePi(input.substring(1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		System.out.println(replacePi(n));
	}

}
