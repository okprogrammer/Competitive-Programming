package lect_11;

public class RecursionSumToK {
	
	public static int[][] subsetsSumK(int input[], int k,int index) {
		// Write your code here 
		if(input.length==index) {
			if(k==0) {
			  int[][]arr = new int[1][0];
			  return arr;
			}
			else {
				int[][]arr = new int[0][0];
				  return arr;
			}
		}
		//creating first small answer for include index value
		int[][] smallAns1 = subsetsSumK(input,k-input[index],index+1);
		
		//creating second small answer for excluded index
		int[][] smallAns2 = subsetsSumK(input,k,index+1);
		
		//creating a third array for the holding the element for the both the array
		int[][] result = new int[smallAns1.length+smallAns2.length][];
		
		//filling the element of first small answer in result array
		for(int i=0;i<smallAns1.length;i++) {
			//assigning the one more column in the every row
			result[i] = new int[smallAns1[i].length+1];
			//assigning the corresponding index value at every first column
			result[i][0] = input[index];
			for(int j=0;j<smallAns1[i].length;j++) {
				result[i][j+1] = smallAns1[i][j];
			}
		}
		
		
		//filling the result with second small answer
		for(int i=0;i<smallAns2.length;i++) {
			result[i+smallAns1.length] = new int[smallAns2[0].length];
			result[i+smallAns1.length] = smallAns2[i];
		}
		return result;

	}


	public static void main(String[] args) {
		
		int[] input = {1,2,3,5,6,4};
      int[][] arr = subsetsSumK(input,10,0);
      for(int i=0;i<arr.length;i++) {
    	  for(int j=0;j<arr[i].length;j++) {
    		  System.out.print(arr[i][j]+" ");
    	  }
    	  System.out.println();
      }
	}

}
