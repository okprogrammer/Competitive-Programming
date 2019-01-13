package DP;

public class MatrixChainMultiplication {

	static int mcm(int[] input, int start, int end) {
		if (start == end) {
			return 0;
		}
		int minCost = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			int cost = mcm(input, start, i) + mcm(input, i + 1, end) + input[start - 1] * input[i] * input[end];
			if (cost < minCost) {
				minCost = cost;
			}
		}
		return minCost;

	}

	static int mcmM(int[] input, int start, int end, int[][] storage) {
		if (start == end) {
			storage[start][end] = 0;
			return storage[start][end];
		}
		if (storage[start][end] > 0) {
			return storage[start][end];
		}
		int minCost = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			int cost = mcmM(input, start, i, storage) + mcmM(input, i + 1, end, storage)
					+ input[start - 1] * input[i] * input[end];
			if (cost < minCost) {
				minCost = cost;
			}
		}
		storage[start][end] = minCost;
		return minCost;
	}

	static int mcmTopDownDP(int[] input) {
		int[][] storage = new int[input.length][input.length];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < input.length; i++) {
			storage[i][i] = 0;
		}
		for (int L = 2; L < input.length; L++) {
			for (int i = 1; i <= input.length - L; i++) {

				int j = i + L - 1;
				storage[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					storage[i][j] = Math.min(storage[i][j],
							storage[i][k] + storage[k + 1][j] + input[i - 1] * input[k] * input[j]);
				}

			}
		}
		return storage[1][input.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 10, 20, 30, 40 };
		System.out.println(mcm(input, 1, input.length - 1));
		System.out.println(mcmTopDownDP(input));
		int[][] storage = new int[input.length][input.length];
		System.out.println(mcmM(input, 1, input.length - 1, storage));

	}

}
