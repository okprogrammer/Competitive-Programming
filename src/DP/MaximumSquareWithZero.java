package DP;

import java.util.Scanner;

public class MaximumSquareWithZero {
	
	static int maximumSquarewithZeroDP(int[][] input) {
		int[][] storage = new int[input.length][input[0].length];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length; j++) {
				if(i==0 || j==0) {
					if(input[i][j]==0) {
						storage[i][j] = 1;
					}else {
						storage[i][j] = 0;
					}
				}else {
					if(input[i][j]==0) {
						storage[i][j] = Math.min(storage[i-1][j-1], Math.min(storage[i-1][j], storage[i][j-1]))+1;
					}else {
						storage[i][j] = 0;
					}
				}
			}
		}
		 int max = Integer.MIN_VALUE;
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length; j++) {
				if(max<storage[i][j]) {
					max = storage[i][j];
				}
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int input[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j <col; j++) {
				input[i][j] = sc.nextInt();
				
			}
		}
		
		System.out.println(maximumSquarewithZeroDP(input));
	}

}
