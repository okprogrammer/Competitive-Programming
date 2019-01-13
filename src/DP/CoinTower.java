package DP;

public class CoinTower {
	
	static String solve(int n,int x,int y) {
	  int[] dp = new int[n+1];
	  dp[1] = 1;
	  dp[x] = 1;
	  dp[y] = 1;
	  for (int i = 2; i < dp.length; i++) {
		if(dp[i]==0) {
			dp[i] = dp[i-1]^1;
			if(i-x>=1) {
				dp[i] = Math.max(dp[i],dp[i-x]);
			}
			if(i-y>=1) {
				dp[i] = Math.max(dp[i],dp[i-y]);
			}
		}
	}
	  if(dp[n]!=0) {
		  String st = "Whis";
		  return st;
	  }
	  else {
		  String st = "Beerus";
		  return st;
	  }
	}
    public static void main(String[] args) {
		System.out.println(solve(4, 2, 3));
	}
}
