package lect_9;

public class subSequenceArray {
	
	public static int[][] subSets(int input[],int index) {
		// Write your code here
         if(input.length==index){
           int[][] arr = {{}};
           return arr;
         }
         int[][] smallAns = subSets(input,index+1);
         int[][] result = new int[smallAns.length*2][];
         //for assigning column to half row
        for(int i=0;i<smallAns.length;i++) {
        	result[i] = new int[smallAns[i].length];
        }
        //assigning column for next half
        for(int i=0;i<smallAns.length;i++) {
        	result[i+smallAns.length] = new int[smallAns[i].length+1];
        }
        //filling first half row
        for(int i=0;i<smallAns.length;i++) {
        	for(int j=0;j<smallAns[i].length;j++) {
        		result[i][j] = smallAns[i][j];
        	}
        }
       //filling row next half
        for(int i=0;i<smallAns.length;i++) {
        	for(int j=0;j<=smallAns[i].length;j++) {
        		if(j==0) {
        			result[i+smallAns.length][j] = input[index];
        		}
        		else {
        			result[i+smallAns.length][j] = smallAns[i][j-1];	
        		}
        		
        	}
        }
        
         return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {15,20,12};
        int[][] result = subSets(input,0);
        for(int i=0;i<result.length;i++) {
        	for(int j=0;j<result[i].length;j++) {
        		System.out.print(result[i][j]+" ");
        	}
        	System.out.println("");
        }
	}

}
