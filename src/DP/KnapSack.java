package DP;

public class KnapSack {

	static int knapsack(int[] weight, int[] value, int maxWeight, int n, int i) {
		if (i == n || maxWeight == 0) {
			return 0;
		}

		if (weight[i] > maxWeight) {
			return knapsack(weight, value, maxWeight, n, i + 1);
		} else {
			int op1 = knapsack(weight, value, maxWeight, n, i + 1);
			int op2 = value[i] + knapsack(weight, value, maxWeight - weight[i], n, i + 1);
			return Math.max(op1, op2);
		}
	}

	static int knapsackM(int[] weight, int[] value, int maxWeight, int n, int i, int[][] storage) {
		if (i == n || maxWeight == 0) {
			storage[i][maxWeight] = 0;
			return storage[i][maxWeight];
		}

		if (storage[i][maxWeight] > 0) {
			return storage[i][maxWeight];
		}

		if (weight[i] > maxWeight) {
			storage[i][maxWeight] = knapsackM(weight, value, maxWeight, n, i + 1, storage);
			return storage[i][maxWeight];
		} else {
			int op1 = knapsackM(weight, value, maxWeight, n, i + 1, storage);
			int op2 = value[i] + knapsackM(weight, value, maxWeight - weight[i], n, i + 1, storage);
			storage[i][maxWeight] = Math.max(op1, op2);

		}

		return storage[i][maxWeight];

	}

	static int knapsackDP(int[] weight, int[] value, int maxWeight) {

		int[][] storage = new int[value.length + 1][maxWeight + 1];
		for (int i = 0; i <= value.length; i++) {
			
			for (int w = 0; w <= maxWeight; w++) {
				if (i == 0 || w == 0) {
					storage[i][w] = 0;
				} else if (weight[i-1] > w) {
					storage[i][w] = storage[i - 1][w];
				} else {
					storage[i][w] = Math.max(storage[i - 1][w], value[i-1] + storage[i - 1][w - weight[i-1]]);

				}
			}

		}
		return storage[value.length][maxWeight];
	}

	public static void main(String[] args) {
		int[] weight = {2, 3, 4,5 };
		int[] value = {1, 2, 5, 6};
		System.out.println(knapsack(weight, value, 5, value.length, 0));
		int[][] storage = new int[value.length + 1][6];
		System.out.println(knapsackM(weight, value, 5, value.length, 0, storage));
		System.out.println(knapsackDP(weight, value, 8));

	}

}
