package lect_7;

public class maximizationSumofTwoArray {
	
	public static long maximumSumPath(int[] input1, int[] input2) {
	      long maxSum=0;
	      long s1=0,s2=0;
	      int i=0,j=0;
	      int m = input1.length;
	      int n = input2.length;
	      while(i<m && j<n){
	        if(input1[i]<input2[j]){
	          s1=s1+input1[i++];																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																					
	        }
	        else if(input1[i]>input2[j]){
	          s2 = s2+input2[j++];
	        }
	        else{
	          s1 = s1+input1[i++];
	          s2 = s2+input2[j++];
	          if(s1>s2){
	            maxSum = maxSum+s1;
	          }
	          else{
	            maxSum = maxSum+s2;
	          }
	          s1=0;
	          s2=0;
	        }
	      }
	      while(i<m){
	       s1 = s1+input1[i++];
	      }
	      while(j<n){
	        s2 = s2+input2[j++];
	      }
	      if(s1>s2){
	            maxSum = maxSum+s1;
	          }
	          else{
	            maxSum = maxSum+s2;
	          }
			return maxSum;
		}

	public static void main(String[] args) {
		int[] input1 = {1,2,5,4,8,4,-6,2};
		int[] input2 = {1,3,5,4,8,10,16,2};
		System.out.println(maximumSumPath(input1,input2));

	}

}
