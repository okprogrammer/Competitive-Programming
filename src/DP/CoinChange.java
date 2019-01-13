package DP;

public class CoinChange {

	static int countWaysToMakeChange(int denominations[], int value) {
		return countWaysToMakeChange(denominations, value, 0);
	}

	private static int countWaysToMakeChange(int[] denominations, int value, int currentCoin) {
		// TODO Auto-generated method stub
		if (value == 0) {
			return 1;
		}
		if (value < 0) {
			return 0;
		}
		int nCombos = 0;
		for (int coin = currentCoin; coin < denominations.length; coin++) {
			nCombos += countWaysToMakeChange(denominations, value-denominations[coin], coin);
		}
		return nCombos;
	}

	// making the coin ways to represent the amount
	static int countWaysToMakeChangeDP(int[] denominations, int value) {
		int[] storage = new int[value + 1];
		storage[0] = 1;
		for (int coin : denominations) {
			for (int i = 1; i < storage.length; i++) {
				if (i >= coin) {
					storage[i] += storage[i - coin];
				}
			}
		}
		return storage[value];
	}

	public static void main(String[] args) {
		int[] denominations = { 1, 2, 3 };
		System.out.println(countWaysToMakeChange(denominations, 4));
		System.out.println(countWaysToMakeChangeDP(denominations, 4));
	}

}
