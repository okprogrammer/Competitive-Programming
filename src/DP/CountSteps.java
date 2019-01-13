package DP;

import java.util.Scanner;

public class CountSteps {
	/*
	 * 1.) Subtract 1 from it. (n= n - ­1) , 2.) If its divisible by 2, divide by
	 * 2.( if n%2==0, then n= n/2 ) , 3.) If its divisible by 3, divide by 3. (if
	 * n%3 == 0, then n = n / 3 ).
	 */
	// using recurison
	public static int countStepsTo1(int n) {

		int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE;
		if (n == 1) {
			return 0;
		}

		m1 = countStepsTo1(n - 1);

		if (n % 3 == 0) {
			m2 = countStepsTo1(n / 3);
		}
		if (n % 2 == 0) {
			m3 = countStepsTo1(n / 2);
		}

		return 1 + Math.min(m1, Math.min(m2, m3));
	}

	// using table method
	static int countStepsDP(int n, int[] storage) {
		storage[1] = 0;
		for (int i = 2; i <= n; i++) {
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE;
			if (i % 3 == 0) {
				m1 = storage[i / 3];
			}
			if (i % 2 == 0) {
				m2 = storage[i / 2];
			}
			m3 = storage[i - 1];
			storage[i] = 1 + Math.min(m1, Math.min(m2, m3));
		}

		return storage[n];
	}

	// memoization technique

	static int countSteps(int n, int[] storage) {
		if (n == 1) {
			storage[n] = 0;
			return storage[n];
		}

		if (storage[n] != 0) {
			return storage[n];
		}
		int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, m3 = Integer.MAX_VALUE;
		m1 = countSteps(n - 1, storage);
		if (n % 3 == 0) {
			m2 = countSteps(n / 3, storage);
		}
		if (n % 2 == 0) {
			m3 = countSteps(n / 2, storage);
		}
		storage[n] = 1 + Math.min(m1, Math.min(m2, m3));
		return storage[n];
	}

	static int minCount(int n) {
		if (n == 0) {
			return 0;
		}
		int mincount = Integer.MAX_VALUE;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			int ans = minCount(n - (int) Math.pow(i, 2)) + 1;
			if (ans < mincount) {
				mincount = ans;
			}
		}
		return mincount;
	}
  //Not completed
	static int minCountM(int n, int[] storage) {
		if (n == 0 || n == 1 || n == 2 || n == 3) {
			storage[n] = n;
			return storage[n];
		}
		if (storage[n] != 0) {
			return storage[n];
		}

		for (int i = 1; i <= n; i++) {
			storage[i] = minCountM(i,storage);
			for(int j=1;j<i/2;j++) {
				int temp = j*j;
				if(temp > i) {
					break;
				}else {
					storage[i] = Math.min(storage[i], 1+minCountM(i-temp,storage));
				}
				
			}
		}
		return storage[n];
	}

	// minimum count square
	static int minCountDP(int n) {
		int[] storage = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;
		storage[2] = 2;
		storage[3] = 3;
		for (int i = 4; i <= n; i++) {
			storage[i] = i;
			for (int j = 1; j < i; j++) {
				int temp = j * j;
				if (temp > i) {
					break;
				} else {
					storage[i] = Math.min(storage[i], 1 + storage[i - temp]);
				}
			}
		}
		return storage[n];
	}
	static int balancedTreesOfHeightH(int height) {
		int mod = (int)Math.pow(10, 9)+7;
		return balancedTreesOfHeightH(height, mod);
	}
	
    static int balancedTreesOfHeightH(int height,int mod){
			
		  if(height == 0 || height==1) {
			  return 1;
		  }
		  int x = balancedTreesOfHeightH(height-1);
		  int y = balancedTreesOfHeightH(height-2);
		  long res1 = (long)x*x;
		  long res2 = (long)x*y*2;
		  int value1 = (int)(res1%mod);
		  int value2 = (int)(res2%mod);
		  return (value1+value2)%mod;

		}
    //Memoization techniqueu
    static long balancedTreesOfHeightHM(int height) {
    	int mod = (int)Math.pow(10, 9)+7;
    	int[] storage = new int[height+1];
    	return balancedTreesOfHeightHM(height, storage,mod);
    }
	
	  public static int balancedTreesOfHeightHM(int height,int[] storage,int mod){
			
		  if(height == 0 || height==1) {
			  storage[height]=1;
			  return storage[height];
		  }
		  if(storage[height]>0) {
			  return storage[height];  
		  }
		  int x = balancedTreesOfHeightH(height-1);
		  int y = balancedTreesOfHeightH(height-2);
		  long res1 = (long)x*x;
		  long res2 = (long)x*y*2;
		  int value1 = (int)(res1%mod);
		  int value2 = (int)(res2%mod);
		  storage[height] = (value1+value2)%mod;
		  return storage[height];

		}
	  static int balancedTreesHeightDP(int height) {
		  int[] storage = new int[height+1];
		  int mod = (int)Math.pow(10, 9)+7;
		  return balancedTreesHeightDP(height,storage,mod);
	  }
	  
	  static int balancedTreesHeightDP(int height,int[] storage,int mod) {
		  storage[0] = 1;
		  storage[1] = 1;
		  for(int i=2;i<=height;i++) {
			  int x = storage[i-1];
			  int y = storage[i-2];
			  long res1 = (long)x*x;
			  long res2 = (long)x*y*2;
			  int value1 = (int)(res1%mod);
			  int value2 = (int)(res2%mod);
			  storage[i] = (value1+value2)%mod;
		  }
		  return storage[height];
	  }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("minimum count step to1:");
		System.out.println(countStepsTo1(n));
		int[] storage = new int[n + 1];
		System.out.println(countStepsDP(n, storage));
		System.out.println(countSteps(n, storage));
		System.out.println("minimum count square!");
		System.out.println(minCountM(n, storage));
		System.out.println(minCountDP(n));
		System.out.println(minCount(n));
		
		System.out.println("balanced");
		
		System.out.println(balancedTreesOfHeightHM(n));
		System.out.println(balancedTreesOfHeightH(n));
		System.out.println(balancedTreesHeightDP(n));

	}

}
