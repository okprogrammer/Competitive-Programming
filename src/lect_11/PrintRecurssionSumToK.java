package lect_11;

public class PrintRecurssionSumToK {
	public static void printSubsetsSumTok(int input[],int[] resultSoFar,int k,int index) {
		// Base case for recursion
		if(input.length==index) {
			int sum = 0;
			for(int i:resultSoFar) {
				sum = sum+i;
			}
			if(sum==k) {
				for(int i=0;i<resultSoFar.length;i++) {
					System.out.print(resultSoFar[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		//not including number in array
		printSubsetsSumTok(input,resultSoFar,k,index+1);
		int[] newResultSoFar = new int[resultSoFar.length+1];
		int i=0;
		for(;i<resultSoFar.length;i++) {
			newResultSoFar[i] = resultSoFar[i];
		}
		newResultSoFar[i] = input[index];
		//including number in array
		printSubsetsSumTok(input,newResultSoFar,k,index+1);
		
	}      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,4,5,6,3};
		int[] resultSoFar = new int[0];
		printSubsetsSumTok(input,resultSoFar,8,0);

	}

}
