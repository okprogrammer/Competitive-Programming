package lect_7;

public class SumOfArray {
      static int[] sumOfTwoArray(int[] input1,int[] input2) {
    	  int length = input1.length>input2.length?input1.length:input2.length;
    	  int[] result = new int[length+1];
    	  int i=input1.length-1,j=input2.length-1,k=result.length-1;
    	  int sum=0,carry=0;
    	  while(i>=0 && j>=0) {
    		  sum = input1[i--]+input2[j--]+carry;
              result[k--] = sum%10;
              carry = sum/10;
    	  }
    	  while(i>=0) {
    		  sum = input1[i--]+carry;
              result[k--] = sum%10;
              carry = sum/10;
    		  
    	  }
    	  while(j>=0) {
    		  sum = input2[j--]+carry;
              result[k--] = sum%10;
              carry = sum/10;
    	  }
    	  result[0] = carry;
    	  return result;
      }
	public static void main(String[] args) {
		int[] input1= {9,9,2,3};
		int[] input2= {9,9,9};
		int[] input = sumOfTwoArray(input1,input2);
		
		for(int i=0;i<input.length;i++) {
			System.out.print(input[i]+" ");
		}
		

	}

}
