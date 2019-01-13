package DP;

public class Practise2 {
	 // using recursion we are found the largest consecutive sequence in the
	// two string 
	static int lcsWithRecursion(String input1, String input2) {
		if (input1.length() == 0 || input2.length() == 0) {
			return 0;
		}

		if (input1.charAt(0) == input2.charAt(0)) {
			return 1 + lcsWithRecursion(input1.substring(1), input2.substring(1));
		} else {
			return Math.max(lcsWithRecursion(input1.substring(0), input2.substring(1)),
					lcsWithRecursion(input1.substring(1), input2.substring(0)));
		}

	}

	// here we are finding largest consecutive sequence by memoization
	static int lcsWithRecursionDP(String input1, String input2, int[][] storage) {
		int i = input1.length();
		int j = input2.length();
		if (input1.length() == 0 || input2.length() == 0) {
			storage[i][j] = 0;
			return storage[i][j];
		}
       
		if (input1.charAt(0) == input2.charAt(0)) {
			if(storage[i][j]>0) {
				return storage[i][j];
			}
			
			storage[i][j] = 1 + lcsWithRecursionDP(input1.substring(1), input2.substring(1), storage);
		} else {
			if(storage[i][j]>0) {
				return storage[i][j];
			}
			storage[i][j] = Math.max(lcsWithRecursionDP(input1.substring(0), input2.substring(1), storage),
					lcsWithRecursionDP(input1.substring(1), input2.substring(0), storage));
		}
         return storage[i][j];
	}

	// using table method
	static int lcsWithTableMethod(String input1, String input2) {
		int i = input1.length();
		int j = input2.length();
		int[][] table = new int[i+1][j+1];

		for (int x = 0; x <= i; x++) {
			for (int y = 0; y <= j; y++) {
				if (x == 0 || y == 0) {
					table[x][y] = 0;
				} else if (input1.charAt(x-1) == input2.charAt(y-1)) {
					table[x][y] = 1 + table[x - 1][y - 1];
				} else {
					table[x][y] = Math.max(table[x-1][y], table[x][y-1]);
				}
			}
		}
		return table[i][j];

	}
	
	static int min(int a,int b,int c) {
		return Math.min(a, Math.min(b, c));
	}
	
	static int minCost(String input1, String input2) {
		if(input1.length()==0) {
			return input2.length();
		}
		if(input2.length()==0) {
			return input1.length();
		}
		if (input1.charAt(0) == input2.charAt(0)) {
			return minCost(input1.substring(1), input2.substring(1));
		} else {
			//insert(0,1) change(1,1) delete(1,0)
			return 1+min(minCost(input1, input2.substring(1)),
					minCost(input1.substring(1), input2.substring(1)), minCost(input1.substring(1), input2));
		}
	}
	
	static int minCost(String input1, String input2, int m, int n) {
		if (input1.length() == 0) {
			return n;
		}
		if (input2.length() == 0) {
			return m;
		}
		if (input1.charAt(m - 1) == input2.charAt(n - 1)) {
			return minCost(input1, input2, m - 1, n - 1);
		} else {
			// insert(0,1) change(1,1) delete(1,0)
			return 1 + min(minCost(input1, input2, m, n - 1), minCost(input1, input2, m - 1, n - 1),
					minCost(input1, input2, m - 1, n));
		}
	}
	
	//used in mobile recommendatin of words
	
	static int minCostUsingTable(String input1, String input2, int m, int n) {
		int [][] table = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0) {
					table[i][j] = j;
				}
				else if(j==0) {
					table[i][j] = i;
				}
				else if(input1.charAt(i-1)==input2.charAt(j-1)){
					table[i][j] = table[i-1][j-1];
				}
				else {
					table[i][j] = min(table[i-1][j-1],table[i][j-1],table[i-1][j])+1;
				}
			}
		}
		return table[m][n];
	}
  static int mcm(int[] input,int start,int end) {
	  if(start==end) {
		  return 0;
	  }
	  
	  int minCost = Integer.MAX_VALUE;
	  for(int i=start;i<end;i++) {
		  int cost = mcm(input,start,i)+mcm(input,i+1,end)+input[start-1]*input[i]*input[end];
		  if(minCost>cost) {
			  minCost = cost;
		  }
	  }
	  return minCost;
	  
  }
  
 
//520100
	public static void main(String[] args) {
		String input1 = "abcdef";
		String input2 = "azced";
		int[][] storage = new int[input1.length()+1][input2.length()+1];
		System.out.println(lcsWithTableMethod(input1, input2));
		System.out.println(minCost(input1,input2));
		int m = input1.length();
		int n = input2.length();
		System.out.println(minCostUsingTable(input1,input2,m,n));
		int[] input = {10,20,30};
		System.out.println(mcm(input,1,input.length-1));
		
	}

}
