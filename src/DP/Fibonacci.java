package DP;

public class Fibonacci {
      //tabulization
	static long fibWithTable(int n) {
		long[] table = new long[n + 1];
		table[0] = 0;
		table[1] = 1;
		for (int i = 2; i <= n; i++) {
			table[i] = table[i - 1] + table[i - 2];
		}
		return table[n];
	}

	// memoization of fibonacci number
	static long fib(int n, long[] storage) {
		if (n == 0 || n == 1) {
			storage[n] = n;
			return storage[n];
		}
		if (storage[n] > 0) {
			return storage[n];
		}
		storage[n] = fib(n - 1, storage) + fib(n - 2, storage);
		return storage[n];
	}

	static long fib(int n) {
		long[] storage = new long[n + 1];
		return fib(n, storage);
	}
	
	// staircase problem using tabulisation

	public static long staircase(int n) {

		if (n == 1 || n == 2) {
			return n;
		}
		if (n == 3) {
			return 4;
		}
		long[] stair = new long[n + 1];
		stair[1] = 1;
		stair[2] = 2;
		stair[3] = 4;
		for (int i = 4; i <= n; i++) {
			stair[i] = stair[i - 1] + stair[i - 2] + stair[i - 3];
		}
		return stair[n];
	}

	public static void main(String[] args) {

		System.out.println(fib(50));
		System.out.println(fibWithTable(100));

	}

}
