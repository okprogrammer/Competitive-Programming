package DP;

import java.util.Scanner;

public class minCost {
	static int minCostPathM(int[][] input, int i, int j, int[][] storage) {
		int m = input.length;
		int n = input[0].length;

		if (i == m - 1 && j == n - 1) {
			storage[m - 1][n - 1] = input[i][j];
			return storage[i][j];
		}
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}
		if (storage[i][j] > 0) {
			return storage[i][j];
		}

		int op1 = minCostPathM(input, i + 1, j, storage);
		int op2 = minCostPathM(input, i + 1, j + 1, storage);
		int op3 = minCostPathM(input, i, j + 1, storage);

		storage[i][j] = input[i][j] + Math.min(op1, Math.min(op2, op3));

		return storage[i][j];

	}

	static int minCostPath(int[][] input, int i, int j) {
		int m = input.length;
		int n = input[0].length;
		if (i == m - 1 && j == n - 1) {
			return input[i][j];
		}
		if (i >= m || j >= n) {
			return Integer.MAX_VALUE;
		}
		int op1 = minCostPath(input, i + 1, j);
		int op2 = minCostPath(input, i + 1, j + 1);
		int op3 = minCostPath(input, i, j + 1);
		int mincost = input[i][j] + Math.min(op1, Math.min(op2, op3));
		return mincost;
	}

	static int minCostPathDP(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] storage = new int[m + 1][n + 1];
		storage[m - 1][n - 1] = input[m - 1][n - 1];

		// Last row
		for (int j = n - 2; j >= 0; j--) {
			storage[m - 1][j] = storage[m - 1][j + 1] + input[m - 1][j];
		}
		// Last column
		for (int i = m - 2; i >= 0; i--) {
			storage[i][n - 1] = storage[i + 1][n - 1] + input[i][n - 1];
		}
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				storage[i][j] = input[i][j]
						+ Math.min(storage[i + 1][j], Math.min(storage[i][j + 1], storage[i + 1][j + 1]));
			}
		}
		return storage[0][0];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] input = new int[r][c];
		int[][] storage = new int[r][c];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		System.out.println(minCostPath(input, 0, 0));

		System.out.println(minCostPathM(input, 0, 0, storage));
		System.out.println(minCostPathDP(input));
	}

}
