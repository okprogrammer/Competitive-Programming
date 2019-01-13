package DP;

public class Practise9 {

	/*
	 * static int lis(int[] arr, int i) { if (i == 0) { return 1; } if (arr[i] >
	 * arr[i - 1]) { return 1 + lis(arr, i - 1); } else { return lis(arr, i - 1); }
	 * 
	 * }
	 */
	static int lisDP(int[] arr) {

		int[] storage = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			storage[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && storage[i] < storage[j] + 1) {
					storage[i] = storage[j] + 1;
				}
			}
		}

		for (int i = 0; i < storage.length; i++) {
			if (max < storage[i]) {
				max = storage[i];
			}
		}
		return max;
	}

	static int allWays(int x, int n) {
		return allWays(x, x, 0, n);
	}

	static int res = 0;

	private static int allWays(int x, int x2, int k, int n) {

		if (x2 == 0) {
			res++;
		}
		int r = (int) Math.floor(Math.pow(x, 1.0 / n));
		for (int i = k + 1; i <= r; i++) {
			int a = x2 - (int) Math.pow(i, n);
			if (a >= 0) {
				allWays(x, a, i, n);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 11, 1, 16, 8 };
		System.out.println(lisDP(arr));
		System.out.println(allWays(100, 2));
		System.out.println(allWaysM(100, 2));
	}

	public static int canSumTo(int k, int x, int n) {
		int rest = (int) (x - Math.pow(k, n));

		if (rest == 0) {
			return 1;
		} else if (rest < 0) {
			return 0;
		}
		int r = 0;
		for (int i = k + 1; i < rest; i++) {
			r += canSumTo(i, rest, n);

		}

		return r;

	}

	public static int allWaysM(int x, int n) {
		int r = 0;
		for (int i = 1; i < x; i++) {
			r += canSumTo(i, x, n);

		}

		return r;

	}

}
