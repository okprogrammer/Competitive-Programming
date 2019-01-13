package lect_11;

public class SubsequenceOfArray {
	
	static void printSubSet(int[] input,int[] resultSoFar,int index) {
		if(input.length==index) {
			for(int i=0;i<resultSoFar.length;i++) {
				System.out.print(resultSoFar[i]+" ");
			}
			System.out.println();
			return;
			
		}
		printSubSet(input,resultSoFar,index+1);
	    int [] newresultSoFar = new int[resultSoFar.length+1];
	    for(int i=0;i<resultSoFar.length;i++) {
	    	newresultSoFar[i] = resultSoFar[i];
	    }
	    newresultSoFar[resultSoFar.length]= input[index];
		printSubSet(input,newresultSoFar,index+1);
	}
	
	public static void main(String[] args) {
		int[] input = {7,3,5};
		int[] result = new int[0];
		printSubSet(input,result,0);
		
	}

}
