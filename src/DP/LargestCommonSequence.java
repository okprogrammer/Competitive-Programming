package DP;

public class LargestCommonSequence {
    //lcs using recursion
	static int lcs(String input1, String input2) {
		if (input1.length() == 0 || input2.length() == 0) {
			return 0;
		}

		if (input1.charAt(0) == input2.charAt(0)) {
			return 1 + lcs(input1.substring(1), input2.substring(1));
		} else {
			int op1 = lcs(input1.substring(1), input2);
			int op2 = lcs(input1, input2.substring(1));

			return Math.max(op1, op2);
		}
	}

	// lcs using memoization
	static int lcsM(String input1, String input2, int[][] storage) {
		int i = input1.length();
		int j = input2.length();
		if (i == 0 || j == 0) {
			storage[i][j] = 0;
			return storage[i][j];
		}
		if (storage[i][j] > 0) {
			return storage[i][j];
		}
		if (input1.charAt(0) == input2.charAt(0)) {
			storage[i][j] = 1 + lcsM(input1.substring(1), input2.substring(1), storage);
			return storage[i][j];
		} else {
			int op1 = lcsM(input1, input2.substring(1), storage);
			int op2 = lcsM(input1.substring(1), input2, storage);
			storage[i][j] = Math.max(op1, op2);

		}
		return storage[i][j];
	}
 // lcs using tabulazation method
	static int lcsDP(String input1, String input2) {
		int i = input1.length();
		int j = input2.length();
		int[][] storage = new int[i + 1][j + 1];
		for(int x=0;x<=i;x++) {
			for(int y=0;y<=j;y++) {
				if(x==0 || y==0) {
					storage[x][y] = 0;
				}else if(input1.charAt(x-1)== input2.charAt(y-1)){
				     storage[x][y] = 1+storage[x-1][y-1];
				}else {
					storage[x][y] = Math.max(storage[x-1][y], storage[x][y-1]);
				}
			}
		}
		return storage[i][j];
	}

	public static void main(String[] args) {
		String input = "abcdefghi";
		String input1 = "abcdefjjfsfghi";
		int[][] storage = new int[input.length() + 1][input1.length() + 1];
		System.out.println(lcs(input1, input));
		System.out.println(lcsM(input, input1, storage));
		System.out.println(lcsDP(input, input1));
	}

}
